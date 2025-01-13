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
    public partial class manage_student_information : Form
    {
        SqlConnection con = new SqlConnection("Data Source=.;Initial Catalog=student_information_management_system;User ID=sa;Password=799882984");
        public manage_student_information()
        {
            InitializeComponent();
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

        private void button1_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void Close_Click(object sender, EventArgs e)
        {
            manager_manage manager_manage1 = new manager_manage();
            manager_manage1.Show();
            this.Hide();
        }

        private void Insert_Click(object sender, EventArgs e)
        {
            String Mno = textBox1.Text.Trim();
            String Mname = textBox2.Text.Trim();
            String Msex = textBox3.Text.Trim();
            String Mbirth = textBox4.Text.Trim();
            String Mnative = textBox5.Text.Trim();//籍贯
            String Mcelllphone = textBox6.Text.Trim();
            String Mnation = textBox7.Text.Trim();//民族
            String Mgrade = textBox8.Text.Trim();
            String Mdept = textBox9.Text.Trim();
            String Mpassword = EncryptWithMD5(Mno);//密码
            try
            {
                con.Open();
                string insertStr = "INSERT INTO Student(学号,姓名,性别,出生日期,籍贯,手机号码,民族,年级,专业,密码) " +
                    "VALUES('" + Mno + "','" + Mname + "','" + Msex + "','" + Mbirth + "','" + Mnative + "','" + Mcelllphone + "','" + Mnation + "','" + Mgrade + "','" + Mdept + "','" + Mpassword + "')";
                SqlCommand cmd = new SqlCommand(insertStr, con);
                cmd.ExecuteNonQuery();
            }
            catch
            {
                MessageBox.Show("输入数据违反要求");
            }
            finally
            {
                con.Dispose();
            }
            this.studentTableAdapter.Fill(this.student_information_management_systemDataSet3.Student);
        }

        private void manage_student_information_Load(object sender, EventArgs e)
        {
            // TODO: 这行代码将数据加载到表“student_information_management_systemDataSet3.Student”中。您可以根据需要移动或删除它。
            this.studentTableAdapter.Fill(this.student_information_management_systemDataSet3.Student);

        }

        private void Delete_Click(object sender, EventArgs e)
        {
            try
            {
                con.Open();
                string select_id = dataGridView1.SelectedRows[0].Cells[0].Value.ToString();//选择的当前行第一列的值，也就是ID
                string delete_by_id = "delete from Student where 学号=" + select_id;//sql删除语句
                SqlCommand cmd = new SqlCommand(delete_by_id, con);
                cmd.ExecuteNonQuery();
            }
            catch
            {
                MessageBox.Show("请正确选择行!");
            }
            finally
            {
                con.Dispose();
            }
            this.studentTableAdapter.Fill(this.student_information_management_systemDataSet3.Student);
        }

        private void Update_Click(object sender, EventArgs e)
        {
            String Mno = textBox1.Text.Trim();
            String Mname = textBox2.Text.Trim();
            String Msex = textBox3.Text.Trim();
            String Mbirth = textBox4.Text.Trim();
            String Mnative = textBox5.Text.Trim();//籍贯
            String Mcelllphone = textBox6.Text.Trim();
            String Mnation = textBox7.Text.Trim();//民族
            String Mgrade = textBox8.Text.Trim();
            String Mdept = textBox9.Text.Trim();
            try
            {
                con.Open();
                if (Mname != "")
                {
                    string insertStr = "UPDATE Student SET 姓名 = '" + Mname + "' WHERE   学号='" + Mno + "'";
                    SqlCommand cmd = new SqlCommand(insertStr, con);
                    cmd.ExecuteNonQuery();
                }
                if (Msex != "")
                {
                    string insertStr = "UPDATE Student SET 性别 = '" + Msex + "' WHERE   学号='" + Mno + "'";
                    SqlCommand cmd = new SqlCommand(insertStr, con);
                    cmd.ExecuteNonQuery();
                }
                if (Mbirth != "")
                {
                    string insertStr = "UPDATE Student SET 出生日期 = '" + Mbirth + "' WHERE   学号='" + Mno + "'";
                    SqlCommand cmd = new SqlCommand(insertStr, con);
                    cmd.ExecuteNonQuery();
                }
                if (Mnative != "")
                {
                    string insertStr = "UPDATE Student SET 籍贯 = '" + Mnative + "' WHERE   学号='" + Mno + "'";
                    SqlCommand cmd = new SqlCommand(insertStr, con);
                    cmd.ExecuteNonQuery();
                }
                if (Mcelllphone != "")
                {
                    string insertStr = "UPDATE Student SET 手机号码 = '" + Mcelllphone + "' WHERE   学号='" + Mno + "'";
                    SqlCommand cmd = new SqlCommand(insertStr, con);
                    cmd.ExecuteNonQuery();
                }
                if (Mnation != "")
                {
                    string insertStr = "UPDATE Student SET 民族 = '" + Mnation + "' WHERE   学号='" + Mno + "'";
                    SqlCommand cmd = new SqlCommand(insertStr, con);
                    cmd.ExecuteNonQuery();
                }
                if (Mgrade != "")
                {
                    string insertStr = "UPDATE Student SET 年级 = '" + Mgrade + "' WHERE   学号='" + Mno + "'";
                    SqlCommand cmd = new SqlCommand(insertStr, con);
                    cmd.ExecuteNonQuery();
                }
                if (Mdept != "")
                {
                    string insertStr = "UPDATE Student SET 专业 = '" + Mdept + "' WHERE   学号='" + Mno + "'";
                    SqlCommand cmd = new SqlCommand(insertStr, con);
                    cmd.ExecuteNonQuery();
                }
            }
            catch
            {
                MessageBox.Show("输入数据违反要求!");
            }
            finally
            {
                con.Dispose();
            }
            this.studentTableAdapter.Fill(this.student_information_management_systemDataSet3.Student);
        }

        private void Select_Click(object sender, EventArgs e)
        {
            String Mno = textBox1.Text.Trim();
            String Mname = textBox2.Text.Trim();
            String Msex = textBox3.Text.Trim();
            String Mbirth = textBox4.Text.Trim();
            String Mnative = textBox5.Text.Trim();//籍贯
            String Mcelllphone = textBox6.Text.Trim();
            String Mnation = textBox7.Text.Trim();//民族
            String Mgrade = textBox8.Text.Trim();
            String Mdept = textBox9.Text.Trim();
            String conn = "Data Source=.;Initial Catalog=student_information_management_system;User ID=sa;Password=799882984";
            SqlConnection sqlConnection = new SqlConnection(conn);
            try
            {
                if (Mno != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from Manage where 工号='" + Mno + "'";
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }
                if (Mname != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from Student where 姓名 Like'" + Mname + "%'";
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }
                if (Msex != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from Student where 性别='" + Msex + "'";
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }
                if (Mbirth != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from Student where 出生日期 Like'" + Mbirth + "'";
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }
                if (Mnative != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from Student where 籍贯 Like'" + Mnative + "'";
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }
                if (Mcelllphone != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from Student where 手机号码='" + Mcelllphone + "'";
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }
                if (Mnation != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from Student where 民族 Like'" + Mnation + "'";
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }
                if (Mgrade != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from Student where 年级='" + Mgrade + "'";
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }
                if (Mdept != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from Student where 专业 Like'" + Mdept + "%'";
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }

            }
            catch
            {
                MessageBox.Show("查询语句有误！");
            }
            finally
            {
                sqlConnection.Close();
            }
        }
    }
}
