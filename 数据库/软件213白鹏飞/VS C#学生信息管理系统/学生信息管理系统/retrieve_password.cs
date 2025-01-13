using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 学生信息管理系统
{
    public partial class retrieve_password : Form
    {
        public retrieve_password()
        {
            InitializeComponent();
        }
        public string code;
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
        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            string username = textBox1.Text.Trim();  //取出账号
            string cellphone = textBox2.Text.Trim();  //取出手机号码
            int flag1 = 0;
            int flag2 = 0;

            string myConnString = "Data Source=.;Initial Catalog=student_information_management_system;Persist Security Info=True;User ID=sa;Password=799882984";

            SqlConnection sqlConnection = new SqlConnection(myConnString);  //实例化连接对象
            sqlConnection.Open();

            string sql1 = "select 学号,手机号码 from Student where 学号 = '" + username + "' and 手机号码 = '" + cellphone + "'";                                            //编写SQL命令
            SqlCommand sqlCommand1 = new SqlCommand(sql1, sqlConnection);

            SqlDataReader sqlDataReader1 = sqlCommand1.ExecuteReader();
            if (sqlDataReader1.HasRows )
            {
                if (textBox3.Text.Trim() != "")
                {
                    //使用regex（正则表达式）进行格式设置 至少有数字、大写字母、小写字母各一个。最少3个字符、最长20个字符。
                    Regex regex = new Regex(@"(?=.*[0-9]).{3,15}");

                    if (regex.IsMatch(textBox3.Text))//判断格式是否符合要求
                    {
                        flag1 = 1;
                    }
                 
                }
            }
            sqlDataReader1.Close();
            if (flag1 == 1)
            {
                string password = EncryptWithMD5(textBox3.Text.Trim());
                string sql3 = "update Student set 密码='" + password + "' where 学号='"+username+"'";
                SqlCommand sqlCommand3 = new SqlCommand(sql3, sqlConnection);
                SqlDataReader sqlDataReader3 = sqlCommand3.ExecuteReader();
                MessageBox.Show("修改成功");
                sqlDataReader3.Close();
                Form1 form1 = new Form1();
                form1.Show();
                this.Hide();
            }
            


            string sql2 = "select 工号,手机号码 from Manage where 工号 = '" + username + "' and 手机号码 = '" + cellphone + "'";
            SqlCommand sqlCommand2 = new SqlCommand(sql2, sqlConnection);
            SqlDataReader sqlDataReader2 = sqlCommand2.ExecuteReader();
            if (sqlDataReader2.HasRows)
            {
                if (textBox3.Text.Trim() != "")
                {
                    //使用regex（正则表达式）进行格式设置 至少有数字、大写字母、小写字母各一个。最少3个字符、最长20个字符。
                    Regex regex = new Regex(@"(?=.*[0-9]).{3,15}");

                    if (regex.IsMatch(textBox3.Text))//判断格式是否符合要求
                    {
                        flag2 = 1;
                    }

                }
                sqlDataReader2.Close();
                if (flag2 == 1)
                {
                    string password = EncryptWithMD5(textBox3.Text.Trim());
                    string sql4 = "update Manage set 密码='" + password + "' where 工号='" + username + "'";
                    SqlCommand sqlCommand4 = new SqlCommand(sql4, sqlConnection);
                    SqlDataReader sqlDataReader4 = sqlCommand4.ExecuteReader();
                    MessageBox.Show("修改成功");
                    sqlDataReader4.Close();
                    Form1 form1 = new Form1();
                    form1.Show();
                    this.Hide();
                }
            }
            else
            {
                label5.Text = "输入密码错误或手机号码错误，请重新输入";
                textBox1.Text = "";
                textBox2.Text = "";
                textBox3.Text = "";
                return;
            }
            sqlConnection.Close();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            Form1 form1 = new Form1();
            form1.Show();
            this.Hide();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            textBox1.Text = "";
            textBox2.Text = "";
            textBox3.Text = "";
        }
    }
}
