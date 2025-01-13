using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 学生信息管理系统
{
    public partial class student_SC : Form
    {
        SqlConnection con = new SqlConnection("Data Source=.;Initial Catalog=student_information_management_system;User ID=sa;Password=799882984");
        public student_SC()
        {
            InitializeComponent();
        }

        private void student_SC_Load(object sender, EventArgs e)
        {
            // TODO: 这行代码将数据加载到表“student_information_management_systemDataSet11.SC”中。您可以根据需要移动或删除它。
            this.sCTableAdapter1.Fill(this.student_information_management_systemDataSet11.SC);
            // TODO: 这行代码将数据加载到表“student_information_management_systemDataSet7.SC”中。您可以根据需要移动或删除它。
            this.sCTableAdapter.Fill(this.student_information_management_systemDataSet7.SC);
            String Sno = Class1.UserID;
            String conn = "Data Source=.;Initial Catalog=student_information_management_system;User ID=sa;Password=799882984";
            SqlConnection sqlConnection = new SqlConnection(conn);
            try
            {
                sqlConnection.Open();
                String select_by_id = "select * from SC where 学号='" + Sno + "'";
                SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                BindingSource bindingSource = new BindingSource();
                bindingSource.DataSource = sqlDataReader;
                dataGridView1.DataSource = bindingSource;
            }
            catch
            {

            }
            finally
            {
                sqlConnection.Close();
            }
        }

        private void Close_Click(object sender, EventArgs e)
        {
            student_manage student_manage1 = new student_manage();
            student_manage1.Show();
            this.Hide();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            String conn = "Data Source=.;Initial Catalog=student_information_management_system;User ID=sa;Password=799882984";
            SqlConnection sqlConnection = new SqlConnection(conn);
            String str = Class1.UserID;
            try
            {
                sqlConnection.Open();
                String select_by_id = "select * from SC where 成绩<60 AND 学号='" + str + "'";
                SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                BindingSource bindingSource = new BindingSource();
                bindingSource.DataSource = sqlDataReader;
                dataGridView1.DataSource = bindingSource;
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

        private void Select_Click(object sender, EventArgs e)
        {

            String Cno = textBox1.Text.Trim();
            String Cname = textBox2.Text.Trim();
            String str = Class1.UserID;
            String conn = "Data Source=.;Initial Catalog=student_information_management_system;User ID=sa;Password=799882984";
            SqlConnection sqlConnection = new SqlConnection(conn);
            try
            {
                if (Cno != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from SC where 学号='" + str + "'AND 课程号='"+Cno+"'";
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }
                if (Cname != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from SC where 学号='" + str + "'AND 课程名 Like'" + Cname + "%'";
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
