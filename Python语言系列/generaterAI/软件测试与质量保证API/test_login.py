import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import psycopg2

class LoginTestCase(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.base_url = 'http://127.0.0.1:5000'

        # Connect to the PostgreSQL database
        self.connection = psycopg2.connect(
            host='127.0.0.1',
            database='python',
            user='postgres',
            password='2941541654'
        )
        self.cursor = self.connection.cursor()

    def tearDown(self):
        self.driver.quit()
        # Close the database connection
        self.cursor.close()
        self.connection.close()

    def get_test_data_from_database(self):
        # Execute a query to fetch test data from the 'user' table
        self.cursor.execute('SELECT user, password FROM "user"')
        return self.cursor.fetchall()

    def test_login_with_database_data(self):
        test_data_list = self.get_test_data_from_database()

        for test_data in test_data_list:
            username, password = test_data

            self.driver.get(self.base_url)
            username_input = self.driver.find_element(By.ID, 'username')
            password_input = self.driver.find_element(By.ID, 'password')
            submit_button = self.driver.find_element(By.CSS_SELECTOR, 'input[type="submit"]')

            username_input.send_keys(username)
            password_input.send_keys(password)
            submit_button.click()

            WebDriverWait(self.driver, 10).until(
                EC.presence_of_element_located((By.TAG_NAME, 'body'))
            )

            result_text = self.driver.find_element(By.TAG_NAME, 'body').text

            if 'Login successful' in result_text:
                self.assertIn('Login successful', result_text)
            elif 'Login failed' in result_text:
                self.assertIn('Login failed', result_text)
            else:
                self.fail(f"Unexpected result: {result_text}")

if __name__ == '__main__':
    unittest.main()
