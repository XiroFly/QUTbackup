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
    public partial class manage_course : Form
    {
        SqlConnection con = new SqlConnection("Data Source=.;Initial Catalog=student_information_management_system;User ID=sa;Password=799882984");
        public manage_course()
        {
            InitializeComponent();
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
            String Cno = textBox1.Text.Trim();//课程号
            String Cname = textBox2.Text.Trim();//课程名
            String Credit = textBox3.Text.Trim();//学分
            String Cplace = textBox4.Text.Trim();//上课地点
            String Ctime = textBox5.Text.Trim();//上课时间
            try
            {
                con.Open();
                string insertStr = "INSERT INTO Course(课程号,课程名,学分,上课地点,上课时间) " +
                    "VALUES('" + Cno + "','" + Cname + "','" + Credit + "','" + Cplace + "','" + Ctime + "')";
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
            this.courseTableAdapter.Fill(this.student_information_management_systemDataSet4.Course);
        }

        private void manage_course_Load(object sender, EventArgs e)
        {
            // TODO: 这行代码将数据加载到表“student_information_management_systemDataSet4.Course”中。您可以根据需要移动或删除它。
            this.courseTableAdapter.Fill(this.student_information_management_systemDataSet4.Course);

        }

        private void Delete_Click(object sender, EventArgs e)
        {
            try
            {
                con.Open();
                string select_id = dataGridView1.SelectedRows[0].Cells[0].Value.ToString();//选择的当前行第一列的值，也就是ID
                string delete_by_id = "delete from Course where 课程号=" + select_id;//sql删除语句
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
            this.courseTableAdapter.Fill(this.student_information_management_systemDataSet4.Course);
        }

        private void Update_Click(object sender, EventArgs e)
        {
            String Cno = textBox1.Text.Trim();//课程号
            String Cname = textBox2.Text.Trim();//课程名
            String Credit = textBox3.Text.Trim();//学分
            String Cplace = textBox4.Text.Trim();//上课地点
            String Ctime = textBox5.Text.Trim();//上课时间
            try
            {
                con.Open();
                if (Cname != "")
                {
                    string insertStr = "UPDATE Course SET 课程名 = '" + Cname + "' WHERE   课程号='" + Cno + "'";
                    SqlCommand cmd = new SqlCommand(insertStr, con);
                    cmd.ExecuteNonQuery();
                }
                if (Credit != "")
                {
                    string insertStr = "UPDATE Course SET 学分 = '" + Credit + "' WHERE   课程号='" + Cno + "'";
                    SqlCommand cmd = new SqlCommand(insertStr, con);
                    cmd.ExecuteNonQuery();
                }
                if (Cplace != "")
                {
                    string insertStr = "UPDATE Course SET 上课地点 = '" + Cplace + "' WHERE   课程号='" + Cno + "'";
                    SqlCommand cmd = new SqlCommand(insertStr, con);
                    cmd.ExecuteNonQuery();
                }
                if (Ctime != "")
                {
                    string insertStr = "UPDATE Course SET 上课时间 = '" + Ctime + "' WHERE   课程号='" + Cno + "'";
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
            this.courseTableAdapter.Fill(this.student_information_management_systemDataSet4.Course);
        }

        private void Select_Click(object sender, EventArgs e)
        {
            String Cno = textBox1.Text.Trim();//课程号
            String Cname = textBox2.Text.Trim();//课程名
            String Credit = textBox3.Text.Trim();//学分
            String Cplace = textBox4.Text.Trim();//上课地点
            String Ctime = textBox5.Text.Trim();//上课时间
            String conn = "Data Source=.;Initial Catalog=student_information_management_system;User ID=sa;Password=799882984";
            SqlConnection sqlConnection = new SqlConnection(conn);
            try
            {
                if (Cno != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from Course where 课程号='" + Cno + "'";
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }
                if (Cname != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from Course where 课程名 Like'" + Cname + "%'";
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }
                if (Credit != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from Course where 学分='" + Credit + "'";
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }
                if (Cplace != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from Course where 上课地点 Like'" + Cplace + "%'";
                    SqlCommand sqlCommand = new SqlCommand(select_by_id, sqlConnection);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    BindingSource bindingSource = new BindingSource();
                    bindingSource.DataSource = sqlDataReader;
                    dataGridView1.DataSource = bindingSource;
                }
                if (Ctime != "")
                {
                    sqlConnection.Open();
                    String select_by_id = "select * from Course where 上课时间 Like'" + Ctime + "%'";
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
