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
    public partial class manage_SCcs : Form
    {
        SqlConnection con = new SqlConnection("Data Source=.;Initial Catalog=student_information_management_system;User ID=sa;Password=799882984");
        public manage_SCcs()
        {
            InitializeComponent();
        }

        private void manage_SCcs_Load(object sender, EventArgs e)
        {
            // TODO: 这行代码将数据加载到表“student_information_management_systemDataSet12.SC”中。您可以根据需要移动或删除它。
            this.sCTableAdapter1.Fill(this.student_information_management_systemDataSet12.SC);
            // TODO: 这行代码将数据加载到表“student_information_management_systemDataSet5.SC”中。您可以根据需要移动或删除它。
            //this.sCTableAdapter.Fill(this.student_information_management_systemDataSet5.SC);

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

            String Sno = textBox1.Text.Trim();
            String Sname = textBox2.Text.Trim();
            String Cno = textBox3.Text.Trim();
            String Cname = textBox4.Text.Trim();
            String Grade = textBox5.Text.Trim();
            String Credit = textBox6.Text.Trim();

            try
            {
                con.Open();
                if(Grade!="" && Credit != "")
                {
                    string insertStr = "INSERT INTO SC(学号,姓名,课程号,课程名,成绩,学分) " +
                    "VALUES('" + Sno + "','" + Sname + "','" + Cno + "','" + Cname + "'," + Grade + "," + Credit + ")";
                    SqlCommand cmd = new SqlCommand(insertStr, con);
                    cmd.ExecuteNonQuery();
                }
            }
            catch
            {
                MessageBox.Show("输入数据违反要求");
            }
            finally
            {
                con.Dispose();
            }
            this.sCTableAdapter1.Fill(this.student_information_management_systemDataSet12.SC);
        }

        private void Delete_Click(object sender, EventArgs e)
        {
            try
            {
                con.Open();
                string select_id1 = dataGridView1.SelectedRows[0].Cells[0].Value.ToString();//选择的当前行第一列的值，也就是ID
                string select_id2 = dataGridView1.SelectedRows[0].Cells[2].Value.ToString().Trim();
                string delete_by_id = "delete from SC where 学号='" + select_id1+ "' AND 课程号='"+select_id2+ "'";//sql删除语句
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
            this.sCTableAdapter1.Fill(this.student_information_management_systemDataSet12.SC);
        }

        private void Update_Click(object sender, EventArgs e)
        {
            String Sno = textBox1.Text.Trim();
            String Cno = textBox3.Text.Trim();
            String Grade = textBox5.Text.Trim();
            try
            {
                con.Open();
                    string insertStr = "UPDATE SC SET 成绩 = " + Grade + " WHERE   学号='" + Sno + "' AND　课程号='"+ Cno + "'";
                    SqlCommand cmd = new SqlCommand(insertStr, con);
                    cmd.ExecuteNonQuery();
            }
            catch
            {
                MessageBox.Show("输入数据违反要求!");
            }
            finally
            {
                con.Dispose();
            }
            this.sCTableAdapter1.Fill(this.student_information_management_systemDataSet12.SC);
        }

        private void Select_Click(object sender, EventArgs e)
        {
            String Sno = textBox1.Text.Trim();
            String Sname = textBox2.Text.Trim();
            String Cno = textBox3.Text.Trim();
            String Cname = textBox4.Text.Trim();
            String  Grade =textBox5.Text.Trim();
            String Credit = textBox6.Text.Trim();
            String conn = "Data Source=.;Initial Catalog=student_information_management_system;User ID=sa;Password=799882984";
            SqlConnection sqlConnection = new SqlConnection(conn);
            try
            {
                if (Sno != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from SC where 学号='" + Sno + "'";
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }
                if (Sname != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from SC where 姓名 Like'" + Sname + "%'";
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }
                if (Cno != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from SC where 课程号='" + Cno + "'";
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }
                if (Cname != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from SC where 课程名 Like'" + Cname + "%'";
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }
                if (Grade != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from SC where 成绩 =" + Grade ;
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }
                if (Credit != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from SC where 学分=" + Credit;
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
/* 
*/