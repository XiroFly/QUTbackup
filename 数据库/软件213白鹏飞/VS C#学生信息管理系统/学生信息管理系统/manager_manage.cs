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
    public partial class manager_manage : Form
    {
        public string MyID;

        public manager_manage()
        {
            InitializeComponent();
        }

        private void manager_manage_Load(object sender, EventArgs e)
        {
            label1.Text = Class1.UserID+" 你好，欢迎进入系统";
            

            

        }

        private void button6_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            Form1 form1 = new Form1();
            form1.Show();
            this.Hide();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            manage_manager_information manage_manager_information1 = new manage_manager_information();
            manage_manager_information1.Show();
            this.Hide();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            manage_student_information manage_student_information1 = new manage_student_information();
            manage_student_information1.Show();
            this.Hide();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            manage_course manage_course1 = new manage_course();
            manage_course1.Show();
            this.Hide();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            manage_SCcs manage_SCcs1 = new manage_SCcs();
            manage_SCcs1.Show();
            this.Hide();
        }
    }
}
