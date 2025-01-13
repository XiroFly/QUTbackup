namespace 学生信息管理系统
{
    partial class manage_course
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
            this.label10 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.label6 = new System.Windows.Forms.Label();
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
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.student_information_management_systemDataSet4 = new 学生信息管理系统.student_information_management_systemDataSet4();
            this.courseBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.courseTableAdapter = new 学生信息管理系统.student_information_management_systemDataSet4TableAdapters.CourseTableAdapter();
            this.课程号DataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.课程名DataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.学分DataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.上课地点DataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.上课时间DataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.student_information_management_systemDataSet4)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.courseBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.ForeColor = System.Drawing.Color.Red;
            this.label10.Location = new System.Drawing.Point(46, 561);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(278, 18);
            this.label10.TabIndex = 62;
            this.label10.Text = "进行修改操作时，必须输入课程号";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.ForeColor = System.Drawing.Color.Red;
            this.label9.Location = new System.Drawing.Point(46, 526);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(620, 18);
            this.label9.TabIndex = 61;
            this.label9.Text = "进行添加操作时，要求课程号、课程名、学分、上课地点，上课时间为非空。";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(921, 467);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(100, 30);
            this.button1.TabIndex = 56;
            this.button1.Text = "关闭";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(46, 324);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(170, 18);
            this.label6.TabIndex = 55;
            this.label6.Text = "请根据需要进行操作";
            // 
            // textBox5
            // 
            this.textBox5.Location = new System.Drawing.Point(742, 417);
            this.textBox5.Name = "textBox5";
            this.textBox5.Size = new System.Drawing.Size(100, 28);
            this.textBox5.TabIndex = 54;
            // 
            // textBox4
            // 
            this.textBox4.Location = new System.Drawing.Point(567, 417);
            this.textBox4.Name = "textBox4";
            this.textBox4.Size = new System.Drawing.Size(100, 28);
            this.textBox4.TabIndex = 53;
            // 
            // textBox3
            // 
            this.textBox3.Location = new System.Drawing.Point(385, 417);
            this.textBox3.Name = "textBox3";
            this.textBox3.Size = new System.Drawing.Size(100, 28);
            this.textBox3.TabIndex = 52;
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(214, 417);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(100, 28);
            this.textBox2.TabIndex = 51;
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(49, 417);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(100, 28);
            this.textBox1.TabIndex = 50;
            // 
            // Close
            // 
            this.Close.Location = new System.Drawing.Point(742, 467);
            this.Close.Name = "Close";
            this.Close.Size = new System.Drawing.Size(100, 30);
            this.Close.TabIndex = 49;
            this.Close.Text = "返回";
            this.Close.UseVisualStyleBackColor = true;
            this.Close.Click += new System.EventHandler(this.Close_Click);
            // 
            // Select
            // 
            this.Select.Location = new System.Drawing.Point(567, 467);
            this.Select.Name = "Select";
            this.Select.Size = new System.Drawing.Size(100, 30);
            this.Select.TabIndex = 48;
            this.Select.Text = "查";
            this.Select.UseVisualStyleBackColor = true;
            this.Select.Click += new System.EventHandler(this.Select_Click);
            // 
            // Update
            // 
            this.Update.Location = new System.Drawing.Point(385, 467);
            this.Update.Name = "Update";
            this.Update.Size = new System.Drawing.Size(100, 30);
            this.Update.TabIndex = 47;
            this.Update.Text = "改";
            this.Update.UseVisualStyleBackColor = true;
            this.Update.Click += new System.EventHandler(this.Update_Click);
            // 
            // Delete
            // 
            this.Delete.Location = new System.Drawing.Point(214, 467);
            this.Delete.Name = "Delete";
            this.Delete.Size = new System.Drawing.Size(100, 30);
            this.Delete.TabIndex = 46;
            this.Delete.Text = "删";
            this.Delete.UseVisualStyleBackColor = true;
            this.Delete.Click += new System.EventHandler(this.Delete_Click);
            // 
            // Insert
            // 
            this.Insert.Location = new System.Drawing.Point(49, 467);
            this.Insert.Name = "Insert";
            this.Insert.Size = new System.Drawing.Size(100, 30);
            this.Insert.TabIndex = 45;
            this.Insert.Text = "增";
            this.Insert.UseVisualStyleBackColor = true;
            this.Insert.Click += new System.EventHandler(this.Insert_Click);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(751, 379);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(80, 18);
            this.label5.TabIndex = 44;
            this.label5.Text = "上课时间";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(577, 379);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(80, 18);
            this.label4.TabIndex = 43;
            this.label4.Text = "上课地点";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(410, 379);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(44, 18);
            this.label3.TabIndex = 42;
            this.label3.Text = "学分";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(231, 379);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(62, 18);
            this.label2.TabIndex = 41;
            this.label2.Text = "课程名";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(68, 379);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(62, 18);
            this.label1.TabIndex = 40;
            this.label1.Text = "课程号";
            // 
            // dataGridView1
            // 
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.课程号DataGridViewTextBoxColumn,
            this.课程名DataGridViewTextBoxColumn,
            this.学分DataGridViewTextBoxColumn,
            this.上课地点DataGridViewTextBoxColumn,
            this.上课时间DataGridViewTextBoxColumn});
            this.dataGridView1.DataSource = this.courseBindingSource;
            this.dataGridView1.Location = new System.Drawing.Point(-1, 1);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.RowHeadersWidth = 62;
            this.dataGridView1.Size = new System.Drawing.Size(1124, 298);
            this.dataGridView1.TabIndex = 39;
            // 
            // student_information_management_systemDataSet4
            // 
            this.student_information_management_systemDataSet4.DataSetName = "student_information_management_systemDataSet4";
            this.student_information_management_systemDataSet4.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // courseBindingSource
            // 
            this.courseBindingSource.DataMember = "Course";
            this.courseBindingSource.DataSource = this.student_information_management_systemDataSet4;
            // 
            // courseTableAdapter
            // 
            this.courseTableAdapter.ClearBeforeFill = true;
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
            // 学分DataGridViewTextBoxColumn
            // 
            this.学分DataGridViewTextBoxColumn.DataPropertyName = "学分";
            this.学分DataGridViewTextBoxColumn.HeaderText = "学分";
            this.学分DataGridViewTextBoxColumn.MinimumWidth = 8;
            this.学分DataGridViewTextBoxColumn.Name = "学分DataGridViewTextBoxColumn";
            this.学分DataGridViewTextBoxColumn.Width = 150;
            // 
            // 上课地点DataGridViewTextBoxColumn
            // 
            this.上课地点DataGridViewTextBoxColumn.DataPropertyName = "上课地点";
            this.上课地点DataGridViewTextBoxColumn.HeaderText = "上课地点";
            this.上课地点DataGridViewTextBoxColumn.MinimumWidth = 8;
            this.上课地点DataGridViewTextBoxColumn.Name = "上课地点DataGridViewTextBoxColumn";
            this.上课地点DataGridViewTextBoxColumn.Width = 150;
            // 
            // 上课时间DataGridViewTextBoxColumn
            // 
            this.上课时间DataGridViewTextBoxColumn.DataPropertyName = "上课时间";
            this.上课时间DataGridViewTextBoxColumn.HeaderText = "上课时间";
            this.上课时间DataGridViewTextBoxColumn.MinimumWidth = 8;
            this.上课时间DataGridViewTextBoxColumn.Name = "上课时间DataGridViewTextBoxColumn";
            this.上课时间DataGridViewTextBoxColumn.Width = 150;
            // 
            // manage_course
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 18F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1127, 636);
            this.Controls.Add(this.label10);
            this.Controls.Add(this.label9);
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
            this.Name = "manage_course";
            this.Text = "学生信息管理系统";
            this.Load += new System.EventHandler(this.manage_course_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.student_information_management_systemDataSet4)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.courseBindingSource)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label label6;
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
        private System.Windows.Forms.DataGridView dataGridView1;
        private student_information_management_systemDataSet4 student_information_management_systemDataSet4;
        private System.Windows.Forms.BindingSource courseBindingSource;
        private student_information_management_systemDataSet4TableAdapters.CourseTableAdapter courseTableAdapter;
        private System.Windows.Forms.DataGridViewTextBoxColumn 课程号DataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn 课程名DataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn 学分DataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn 上课地点DataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn 上课时间DataGridViewTextBoxColumn;
    }
}