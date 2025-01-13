namespace 学生信息管理系统
{
    partial class manage_manager_information
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.工号DataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.姓名DataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.性别DataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.出生日期DataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.籍贯DataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.手机号码DataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.民族DataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.manageBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.student_information_management_systemDataSet2 = new 学生信息管理系统.student_information_management_systemDataSet2();
            this.manageTableAdapter = new 学生信息管理系统.student_information_management_systemDataSet2TableAdapters.ManageTableAdapter();
            this.textBox5 = new System.Windows.Forms.TextBox();
            this.textBox4 = new System.Windows.Forms.TextBox();
            this.textBox3 = new System.Windows.Forms.TextBox();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.Close = new System.Windows.Forms.Button();
            this.Select = new System.Windows.Forms.Button();
            this.Update = new System.Windows.Forms.Button();
            this.Delete = new System.Windows.Forms.Button();
            this.Insert = new System.Windows.Forms.Button();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.textBox6 = new System.Windows.Forms.TextBox();
            this.textBox7 = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.manageBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.student_information_management_systemDataSet2)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.工号DataGridViewTextBoxColumn,
            this.姓名DataGridViewTextBoxColumn,
            this.性别DataGridViewTextBoxColumn,
            this.出生日期DataGridViewTextBoxColumn,
            this.籍贯DataGridViewTextBoxColumn,
            this.手机号码DataGridViewTextBoxColumn,
            this.民族DataGridViewTextBoxColumn});
            this.dataGridView1.DataSource = this.manageBindingSource;
            this.dataGridView1.Location = new System.Drawing.Point(0, 3);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.RowHeadersWidth = 62;
            this.dataGridView1.Size = new System.Drawing.Size(1214, 298);
            this.dataGridView1.TabIndex = 0;
            this.dataGridView1.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellContentClick);
            // 
            // 工号DataGridViewTextBoxColumn
            // 
            this.工号DataGridViewTextBoxColumn.DataPropertyName = "工号";
            this.工号DataGridViewTextBoxColumn.HeaderText = "工号";
            this.工号DataGridViewTextBoxColumn.MinimumWidth = 8;
            this.工号DataGridViewTextBoxColumn.Name = "工号DataGridViewTextBoxColumn";
            this.工号DataGridViewTextBoxColumn.Width = 150;
            // 
            // 姓名DataGridViewTextBoxColumn
            // 
            this.姓名DataGridViewTextBoxColumn.DataPropertyName = "姓名";
            this.姓名DataGridViewTextBoxColumn.HeaderText = "姓名";
            this.姓名DataGridViewTextBoxColumn.MinimumWidth = 8;
            this.姓名DataGridViewTextBoxColumn.Name = "姓名DataGridViewTextBoxColumn";
            this.姓名DataGridViewTextBoxColumn.Width = 150;
            // 
            // 性别DataGridViewTextBoxColumn
            // 
            this.性别DataGridViewTextBoxColumn.DataPropertyName = "性别";
            this.性别DataGridViewTextBoxColumn.HeaderText = "性别";
            this.性别DataGridViewTextBoxColumn.MinimumWidth = 8;
            this.性别DataGridViewTextBoxColumn.Name = "性别DataGridViewTextBoxColumn";
            this.性别DataGridViewTextBoxColumn.Width = 150;
            // 
            // 出生日期DataGridViewTextBoxColumn
            // 
            this.出生日期DataGridViewTextBoxColumn.DataPropertyName = "出生日期";
            this.出生日期DataGridViewTextBoxColumn.HeaderText = "出生日期";
            this.出生日期DataGridViewTextBoxColumn.MinimumWidth = 8;
            this.出生日期DataGridViewTextBoxColumn.Name = "出生日期DataGridViewTextBoxColumn";
            this.出生日期DataGridViewTextBoxColumn.Width = 150;
            // 
            // 籍贯DataGridViewTextBoxColumn
            // 
            this.籍贯DataGridViewTextBoxColumn.DataPropertyName = "籍贯";
            this.籍贯DataGridViewTextBoxColumn.HeaderText = "籍贯";
            this.籍贯DataGridViewTextBoxColumn.MinimumWidth = 8;
            this.籍贯DataGridViewTextBoxColumn.Name = "籍贯DataGridViewTextBoxColumn";
            this.籍贯DataGridViewTextBoxColumn.Width = 150;
            // 
            // 手机号码DataGridViewTextBoxColumn
            // 
            this.手机号码DataGridViewTextBoxColumn.DataPropertyName = "手机号码";
            this.手机号码DataGridViewTextBoxColumn.HeaderText = "手机号码";
            this.手机号码DataGridViewTextBoxColumn.MinimumWidth = 8;
            this.手机号码DataGridViewTextBoxColumn.Name = "手机号码DataGridViewTextBoxColumn";
            this.手机号码DataGridViewTextBoxColumn.Width = 150;
            // 
            // 民族DataGridViewTextBoxColumn
            // 
            this.民族DataGridViewTextBoxColumn.DataPropertyName = "民族";
            this.民族DataGridViewTextBoxColumn.HeaderText = "民族";
            this.民族DataGridViewTextBoxColumn.MinimumWidth = 8;
            this.民族DataGridViewTextBoxColumn.Name = "民族DataGridViewTextBoxColumn";
            this.民族DataGridViewTextBoxColumn.Width = 150;
            // 
            // manageBindingSource
            // 
            this.manageBindingSource.DataMember = "Manage";
            this.manageBindingSource.DataSource = this.student_information_management_systemDataSet2;
            // 
            // student_information_management_systemDataSet2
            // 
            this.student_information_management_systemDataSet2.DataSetName = "student_information_management_systemDataSet2";
            this.student_information_management_systemDataSet2.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // manageTableAdapter
            // 
            this.manageTableAdapter.ClearBeforeFill = true;
            // 
            // textBox5
            // 
            this.textBox5.Location = new System.Drawing.Point(743, 419);
            this.textBox5.Name = "textBox5";
            this.textBox5.Size = new System.Drawing.Size(100, 28);
            this.textBox5.TabIndex = 30;
            this.textBox5.TextChanged += new System.EventHandler(this.textBox5_TextChanged);
            // 
            // textBox4
            // 
            this.textBox4.Location = new System.Drawing.Point(568, 419);
            this.textBox4.Name = "textBox4";
            this.textBox4.Size = new System.Drawing.Size(100, 28);
            this.textBox4.TabIndex = 29;
            this.textBox4.TextChanged += new System.EventHandler(this.textBox4_TextChanged);
            // 
            // textBox3
            // 
            this.textBox3.Location = new System.Drawing.Point(386, 419);
            this.textBox3.Name = "textBox3";
            this.textBox3.Size = new System.Drawing.Size(100, 28);
            this.textBox3.TabIndex = 28;
            this.textBox3.TextChanged += new System.EventHandler(this.textBox3_TextChanged);
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(215, 419);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(100, 28);
            this.textBox2.TabIndex = 27;
            this.textBox2.TextChanged += new System.EventHandler(this.textBox2_TextChanged);
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(50, 419);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(100, 28);
            this.textBox1.TabIndex = 26;
            this.textBox1.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // Close
            // 
            this.Close.Location = new System.Drawing.Point(743, 469);
            this.Close.Name = "Close";
            this.Close.Size = new System.Drawing.Size(100, 30);
            this.Close.TabIndex = 25;
            this.Close.Text = "返回";
            this.Close.UseVisualStyleBackColor = true;
            this.Close.Click += new System.EventHandler(this.Close_Click_1);
            // 
            // Select
            // 
            this.Select.Location = new System.Drawing.Point(568, 469);
            this.Select.Name = "Select";
            this.Select.Size = new System.Drawing.Size(100, 30);
            this.Select.TabIndex = 24;
            this.Select.Text = "查";
            this.Select.UseVisualStyleBackColor = true;
            this.Select.Click += new System.EventHandler(this.Select_Click);
            // 
            // Update
            // 
            this.Update.Location = new System.Drawing.Point(386, 469);
            this.Update.Name = "Update";
            this.Update.Size = new System.Drawing.Size(100, 30);
            this.Update.TabIndex = 23;
            this.Update.Text = "改";
            this.Update.UseVisualStyleBackColor = true;
            this.Update.Click += new System.EventHandler(this.Update_Click);
            // 
            // Delete
            // 
            this.Delete.Location = new System.Drawing.Point(215, 469);
            this.Delete.Name = "Delete";
            this.Delete.Size = new System.Drawing.Size(100, 30);
            this.Delete.TabIndex = 22;
            this.Delete.Text = "删";
            this.Delete.UseVisualStyleBackColor = true;
            this.Delete.Click += new System.EventHandler(this.Delete_Click);
            // 
            // Insert
            // 
            this.Insert.Location = new System.Drawing.Point(50, 469);
            this.Insert.Name = "Insert";
            this.Insert.Size = new System.Drawing.Size(100, 30);
            this.Insert.TabIndex = 21;
            this.Insert.Text = "增";
            this.Insert.UseVisualStyleBackColor = true;
            this.Insert.Click += new System.EventHandler(this.Insert_Click_1);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(772, 381);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(44, 18);
            this.label5.TabIndex = 20;
            this.label5.Text = "籍贯";
            this.label5.Click += new System.EventHandler(this.label5_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(578, 381);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(80, 18);
            this.label4.TabIndex = 19;
            this.label4.Text = "出生日期";
            this.label4.Click += new System.EventHandler(this.label4_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(411, 381);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(44, 18);
            this.label3.TabIndex = 18;
            this.label3.Text = "性别";
            this.label3.Click += new System.EventHandler(this.label3_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(242, 381);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(44, 18);
            this.label2.TabIndex = 17;
            this.label2.Text = "姓名";
            this.label2.Click += new System.EventHandler(this.label2_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(76, 381);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(44, 18);
            this.label1.TabIndex = 16;
            this.label1.Text = "工号";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(47, 326);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(170, 18);
            this.label6.TabIndex = 31;
            this.label6.Text = "请根据需要进行操作";
            this.label6.Click += new System.EventHandler(this.label6_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(922, 469);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(100, 30);
            this.button1.TabIndex = 32;
            this.button1.Text = "关闭";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // textBox6
            // 
            this.textBox6.Location = new System.Drawing.Point(922, 419);
            this.textBox6.Name = "textBox6";
            this.textBox6.Size = new System.Drawing.Size(100, 28);
            this.textBox6.TabIndex = 36;
            this.textBox6.TextChanged += new System.EventHandler(this.textBox6_TextChanged);
            // 
            // textBox7
            // 
            this.textBox7.Location = new System.Drawing.Point(1079, 419);
            this.textBox7.Name = "textBox7";
            this.textBox7.Size = new System.Drawing.Size(100, 28);
            this.textBox7.TabIndex = 35;
            this.textBox7.TextChanged += new System.EventHandler(this.textBox7_TextChanged);
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(1117, 381);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(44, 18);
            this.label7.TabIndex = 34;
            this.label7.Text = "民族";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(929, 381);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(80, 18);
            this.label8.TabIndex = 33;
            this.label8.Text = "手机号码";
            this.label8.Click += new System.EventHandler(this.label8_Click);
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.ForeColor = System.Drawing.Color.Red;
            this.label9.Location = new System.Drawing.Point(47, 528);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(1160, 18);
            this.label9.TabIndex = 37;
            this.label9.Text = "进行添加操作时，要求工号，姓名，性别，手机号码非空。性别输入为“男”或者“女”。出生日期规范为：1900-01-01。手机号码为11位数字。";
            this.label9.Click += new System.EventHandler(this.label9_Click);
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.ForeColor = System.Drawing.Color.Red;
            this.label10.Location = new System.Drawing.Point(47, 563);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(260, 18);
            this.label10.TabIndex = 38;
            this.label10.Text = "进行修改操作时，必须输入工号";
            this.label10.Click += new System.EventHandler(this.label10_Click);
            // 
            // manage_manager_information
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 18F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1355, 616);
            this.Controls.Add(this.label10);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.textBox6);
            this.Controls.Add(this.textBox7);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.textBox5);
            this.Controls.Add(this.textBox4);
            this.Controls.Add(this.textBox3);
            this.Controls.Add(this.textBox2);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.Close);
            this.Controls.Add(this.Select);
            this.Controls.Add(this.Update);
            this.Controls.Add(this.Delete);
            this.Controls.Add(this.Insert);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.dataGridView1);
            this.Name = "manage_manager_information";
            this.Text = "学生信息管理系统";
            this.Load += new System.EventHandler(this.manage_manager_information_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.manageBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.student_information_management_systemDataSet2)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private student_information_management_systemDataSet2 student_information_management_systemDataSet2;
        private System.Windows.Forms.BindingSource manageBindingSource;
        private student_information_management_systemDataSet2TableAdapters.ManageTableAdapter manageTableAdapter;
        private System.Windows.Forms.DataGridViewTextBoxColumn 工号DataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn 姓名DataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn 性别DataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn 出生日期DataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn 籍贯DataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn 手机号码DataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn 民族DataGridViewTextBoxColumn;
        private System.Windows.Forms.TextBox textBox5;
        private System.Windows.Forms.TextBox textBox4;
        private System.Windows.Forms.TextBox textBox3;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Button Close;
        private System.Windows.Forms.Button Select;
        private System.Windows.Forms.Button Update;
        private System.Windows.Forms.Button Delete;
        private System.Windows.Forms.Button Insert;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.TextBox textBox6;
        private System.Windows.Forms.TextBox textBox7;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label10;
    }
}