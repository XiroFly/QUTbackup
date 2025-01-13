namespace 学生信息管理系统
{
    partial class student_SC
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
            this.label9 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.label6 = new System.Windows.Forms.Label();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.Close = new System.Windows.Forms.Button();
            this.Select = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.课程号DataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.课程名DataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.成绩DataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.学分DataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.sCBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.student_information_management_systemDataSet7 = new 学生信息管理系统.student_information_management_systemDataSet7();
            this.sCTableAdapter = new 学生信息管理系统.student_information_management_systemDataSet7TableAdapters.SCTableAdapter();
            this.button2 = new System.Windows.Forms.Button();
            this.student_information_management_systemDataSet11 = new 学生信息管理系统.student_information_management_systemDataSet11();
            this.sCBindingSource1 = new System.Windows.Forms.BindingSource(this.components);
            this.sCTableAdapter1 = new 学生信息管理系统.student_information_management_systemDataSet11TableAdapters.SCTableAdapter();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.sCBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.student_information_management_systemDataSet7)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.student_information_management_systemDataSet11)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.sCBindingSource1)).BeginInit();
            this.SuspendLayout();
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.ForeColor = System.Drawing.Color.Red;
            this.label9.Location = new System.Drawing.Point(50, 521);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(530, 36);
            this.label9.TabIndex = 105;
            this.label9.Text = "点击“查”按钮进行查询，查询时应输入课程号或者课程名\r\n点击“查询不及格成绩”按钮，查询时不需要输入课程名和课程号";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(614, 472);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(100, 30);
            this.button1.TabIndex = 102;
            this.button1.Text = "关闭";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(50, 319);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(170, 18);
            this.label6.TabIndex = 101;
            this.label6.Text = "请根据需要进行操作";
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(248, 412);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(100, 28);
            this.textBox2.TabIndex = 97;
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(53, 412);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(100, 28);
            this.textBox1.TabIndex = 96;
            // 
            // Close
            // 
            this.Close.Location = new System.Drawing.Point(452, 472);
            this.Close.Name = "Close";
            this.Close.Size = new System.Drawing.Size(100, 30);
            this.Close.TabIndex = 95;
            this.Close.Text = "返回";
            this.Close.UseVisualStyleBackColor = true;
            this.Close.Click += new System.EventHandler(this.Close_Click);
            // 
            // Select
            // 
            this.Select.Location = new System.Drawing.Point(53, 472);
            this.Select.Name = "Select";
            this.Select.Size = new System.Drawing.Size(100, 30);
            this.Select.TabIndex = 94;
            this.Select.Text = "查";
            this.Select.UseVisualStyleBackColor = true;
            this.Select.Click += new System.EventHandler(this.Select_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(266, 375);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(62, 18);
            this.label4.TabIndex = 89;
            this.label4.Text = "课程名";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(73, 375);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(62, 18);
            this.label3.TabIndex = 88;
            this.label3.Text = "课程号";
            // 
            // dataGridView1
            // 
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.课程号DataGridViewTextBoxColumn,
            this.课程名DataGridViewTextBoxColumn,
            this.成绩DataGridViewTextBoxColumn,
            this.学分DataGridViewTextBoxColumn});
            this.dataGridView1.DataSource = this.sCBindingSource1;
            this.dataGridView1.Location = new System.Drawing.Point(-1, 2);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.RowHeadersWidth = 62;
            this.dataGridView1.Size = new System.Drawing.Size(1214, 298);
            this.dataGridView1.TabIndex = 85;
            // 
            // 课程号DataGridViewTextBoxColumn
            // 
            this.课程号DataGridViewTextBoxColumn.DataPropertyName = "课程号";
            this.课程号DataGridViewTextBoxColumn.HeaderText = "课程号";
            this.课程号DataGridViewTextBoxColumn.MinimumWidth = 8;
            this.课程号DataGridViewTextBoxColumn.Name = "课程号DataGridViewTextBoxColumn";
            this.课程号DataGridViewTextBoxColumn.Width = 150;
            // 
            // 课程名DataGridViewTextBoxColumn
            // 
            this.课程名DataGridViewTextBoxColumn.DataPropertyName = "课程名";
            this.课程名DataGridViewTextBoxColumn.HeaderText = "课程名";
            this.课程名DataGridViewTextBoxColumn.MinimumWidth = 8;
            this.课程名DataGridViewTextBoxColumn.Name = "课程名DataGridViewTextBoxColumn";
            this.课程名DataGridViewTextBoxColumn.Width = 150;
            // 
            // 成绩DataGridViewTextBoxColumn
            // 
            this.成绩DataGridViewTextBoxColumn.DataPropertyName = "成绩";
            this.成绩DataGridViewTextBoxColumn.HeaderText = "成绩";
            this.成绩DataGridViewTextBoxColumn.MinimumWidth = 8;
            this.成绩DataGridViewTextBoxColumn.Name = "成绩DataGridViewTextBoxColumn";
            this.成绩DataGridViewTextBoxColumn.Width = 150;
            // 
            // 学分DataGridViewTextBoxColumn
            // 
            this.学分DataGridViewTextBoxColumn.DataPropertyName = "学分";
            this.学分DataGridViewTextBoxColumn.HeaderText = "学分";
            this.学分DataGridViewTextBoxColumn.MinimumWidth = 8;
            this.学分DataGridViewTextBoxColumn.Name = "学分DataGridViewTextBoxColumn";
            this.学分DataGridViewTextBoxColumn.Width = 150;
            // 
            // sCBindingSource
            // 
            this.sCBindingSource.DataMember = "SC";
            this.sCBindingSource.DataSource = this.student_information_management_systemDataSet7;
            // 
            // student_information_management_systemDataSet7
            // 
            this.student_information_management_systemDataSet7.DataSetName = "student_information_management_systemDataSet7";
            this.student_information_management_systemDataSet7.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // sCTableAdapter
            // 
            this.sCTableAdapter.ClearBeforeFill = true;
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(203, 472);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(204, 30);
            this.button2.TabIndex = 106;
            this.button2.Text = "查询不及格成绩";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // student_information_management_systemDataSet11
            // 
            this.student_information_management_systemDataSet11.DataSetName = "student_information_management_systemDataSet11";
            this.student_information_management_systemDataSet11.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // sCBindingSource1
            // 
            this.sCBindingSource1.DataMember = "SC";
            this.sCBindingSource1.DataSource = this.student_information_management_systemDataSet11;
            // 
            // sCTableAdapter1
            // 
            this.sCTableAdapter1.ClearBeforeFill = true;
            // 
            // student_SC
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 18F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1149, 694);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.textBox2);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.Close);
            this.Controls.Add(this.Select);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.dataGridView1);
            this.Name = "student_SC";
            this.Text = "学生信息管理系统";
            this.Load += new System.EventHandler(this.student_SC_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.sCBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.student_information_management_systemDataSet7)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.student_information_management_systemDataSet11)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.sCBindingSource1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Button Close;
        private System.Windows.Forms.Button Select;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.DataGridView dataGridView1;
        private student_information_management_systemDataSet7 student_information_management_systemDataSet7;
        private System.Windows.Forms.BindingSource sCBindingSource;
        private student_information_management_systemDataSet7TableAdapters.SCTableAdapter sCTableAdapter;
        private System.Windows.Forms.DataGridViewTextBoxColumn 课程号DataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn 课程名DataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn 成绩DataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn 学分DataGridViewTextBoxColumn;
        private System.Windows.Forms.Button button2;
        private student_information_management_systemDataSet11 student_information_management_systemDataSet11;
        private System.Windows.Forms.BindingSource sCBindingSource1;
        private student_information_management_systemDataSet11TableAdapters.SCTableAdapter sCTableAdapter1;
    }
}