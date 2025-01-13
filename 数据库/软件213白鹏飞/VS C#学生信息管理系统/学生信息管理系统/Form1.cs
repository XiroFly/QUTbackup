using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 学生信息管理系统
{
    public partial class Form1 : Form
    {
        
        public Form1()
        {
            InitializeComponent();
        }
        public string code;
        private void Login_Load_1(object sender, EventArgs e)
        {
            //随机实例化 
            Random ran = new Random();
            int number;
            char code1;
            //取五个数 
            for (int i = 0; i < 5; i++)
            {
                number = ran.Next();
                if (number % 2 == 0)
                    code1 = (char)('0' + (char)(number % 10));
                else
                    code1 = (char)('A' + (char)(number % 26)); //转化为字符 

                this.code += code1.ToString();
            }

            label5.Text = code;
        }
        public static string EncryptWithMD5(string source)
        {
            byte[] sor = Encoding.UTF8.GetBytes(source);
            MD5 md5 = MD5.Create();
            byte[] result = md5.ComputeHash(sor);
            StringBuilder strbul = new StringBuilder(40);
            for (int i = 0; i < result.Length; i++)
            {
                strbul.Append(result[i].ToString("x2"));//加密结果"x2"结果为32位,"x3"结果为48位,"x4"结果为64位
            }
            return strbul.ToString();
        }
        private void Form1_Load(object sender, EventArgs e)
        {
            //随机实例化 
            Random ran = new Random();
            int number;
            char code1;
            //取五个数 
            for (int i = 0; i < 5; i++)
            {
                number = ran.Next();
                if (number % 2 == 0)
                    code1 = (char)('0' + (char)(number % 10));
                else
                    code1 = (char)('A' + (char)(number % 26)); //转化为字符 

                this.code += code1.ToString();
            }

            label5.Text = code;
        }
        private void textBox1_TextChanged(object sender,EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            textBox1.Text = "";
            textBox2.Text = "";
            textBox3.Text = "";
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string username = textBox1.Text.Trim();  //取出账号
            string password = EncryptWithMD5(textBox2.Text.Trim());  //取出密码并加密

            // if (username == "admin")
            //   password = "123";//测试用例，便于初始化时候的 admin 密码 123可以顺利登陆。程序完成后可注释掉这行代码。

            //string connstr = ConfigurationManager.ConnectionStrings["connectionString"].ToString(); //读取连接字符串
            string myConnString = "Data Source=.;Initial Catalog=student_information_management_system;Persist Security Info=True;User ID=sa;Password=799882984";

            SqlConnection sqlConnection = new SqlConnection(myConnString);  //实例化连接对象
            sqlConnection.Open();

            string sql1 = "select 学号,密码 from Student where 学号 = '" + username + "' and 密码 = '" + password + "'";                                            //编写SQL命令
            SqlCommand sqlCommand1 = new SqlCommand(sql1, sqlConnection);
            
            SqlDataReader sqlDataReader1 = sqlCommand1.ExecuteReader();
            if (sqlDataReader1.HasRows && textBox3.Text == code)
            {
                Class1.UserID = username;
                student_manage form2 = new student_manage();
                form2.Show();
                this.Hide();
            }
            sqlDataReader1.Close();


            string sql2 = "select 工号,密码 from Manage where 工号 = '" + username + "' and 密码 = '" + password + "'";
            SqlCommand sqlCommand2 = new SqlCommand(sql2, sqlConnection);
            SqlDataReader sqlDataReader2 = sqlCommand2.ExecuteReader();
            if (sqlDataReader2.HasRows && textBox3.Text == code)
            {
                Class1.UserID = username;
                manager_manage form3 = new manager_manage();
                form3.Show();
                this.Hide();
            }
            else
            {
                label6.Text = "登录失败，输入密码或验证码错误";
                textBox1.Text = "";
                textBox2.Text = "";
                textBox3.Text = "";
                return;
            }

            sqlDataReader2.Close();
            sqlConnection.Close();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            retrieve_password form3 = new retrieve_password();
            form3.Show();
            this.Hide();
        }
    }
}
