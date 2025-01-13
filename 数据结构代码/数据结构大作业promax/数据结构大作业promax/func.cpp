#include "func.h"
#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <iostream>
#include <fstream>
#include "string.h"
#include <stack>
#pragma warning(disable:4996)
using namespace std;

extern VexNode result1[100];
extern VexNode result2[100];
extern VexNode result3[100];
extern VexNode result4[100];
extern Class_arrange_Graph G;

void mainmenu()
{
    char key;

    printf("\n\n\n\n");
    printf("		     	    欢迎使用课程编排系统	               \n\n\n");
    printf("______________________________________________________________________\n");
    printf("			     1. 查看课程信息        			  \n");
    printf("______________________________________________________________________\n");
    printf("	 		     2. 修改课程信息                		  \n");
    printf("______________________________________________________________________\n");
    printf("        		     3. 均匀安排课程                   		  \n");
    printf("______________________________________________________________________\n");
    printf("        		     4. 尽快安排课程           			  \n");
    printf("______________________________________________________________________\n");
    printf("        		     5. 关闭程序               			  \n");
    printf("______________________________________________________________________\n");
    printf("\n\n\n\n\t ");
    key = getch();
    key = key - '0';
    switch (key)
    {
    case 1:		system("cls");
        Print_message();
        break;

    case 2:		system("cls");
        Adjust_message();
        break;

    case 3:		system("cls");
        Arrange_Select(AVERAGE);
        break;

    case 4:		system("cls");
        Arrange_Select(QUICKLY);
        break;

    case 5:		exit(0);

    default:
        cout << "该选项无效,请按任意键回主菜单" << endl;
        key = getch();
        system("cls");
        break;
    }

    mainmenu();
}



int Locate(char* ch)		//将C1C2C3……等 变为0 1 2...     课程号对应的位序
{
    return (2 == strlen(ch)) ? ch[1] - '1' : (ch[1] - '0') * 10 + ch[2] - '1';
}



void Read_file()
{
    FILE* fp = fopen("courses.txt", "r");
    if (NULL == fp)
    {
        printf("未找到文件,可能文件路径有误！！！");
        exit(1);
    }

    G.mes = (Message*)malloc(sizeof(Message));

    fscanf(fp, "%d%d%d", &G.mes->term_num, &G.mes->max_credit, &G.VexNum); 	//读取学期数，每学期最大学分，课程总数
    if (G.VexNum > MaxClass || G.mes->term_num > MaxTerm || G.mes->max_credit > MaxCredit)
    {
        cout << "课程总数或学期数目或每学期最大学分超过上限" << endl;
        fclose(fp);
        exit(1);		//异常退出
    }
   // G.Vex = (VexNode*)malloc(sizeof(VexNode) * G.VexNum);
    G.Vex = new VexNode[G.VexNum];
    int i = 0;
    for (; i < G.VexNum; i++)
        G.Vex[i].FirstArc = nullptr;

    for (i = 0; i < G.VexNum; i++)		//读取课程信息
    {
        fscanf(fp, "%s%d", G.Vex[i].data, &G.Vex[i].credit);		//读取课程名称和学分

        while ('\n' != fgetc(fp)) 	//根据先修课程建立邻接表结点
        {
            char str[4];
            int s;
            fscanf(fp, "%s", str);
            s = Locate(str);
            if (s < 0 || s >= G.VexNum) 		//判断课程是否有错误
            {
                printf("%s课程错误，本专业无其先修课程！\n", G.Vex[i].data);
                fclose(fp);
                exit(1);
            }
            AdjVexNode* p = (AdjVexNode*)malloc(sizeof(AdjVexNode));		//更新邻接表结点
            p->AdjVex = s;
            p->Next = G.Vex[i].FirstArc;
            G.Vex[i].FirstArc = p;

        }
    }
    fclose(fp);

    AdjVexNode* p;
    for (i = 0; i < G.VexNum; i++)		//初始化入度
        G.Vex[i].In_degree = 0;
    for (i = 0; i < G.VexNum; i++)			//计算各节点入度
    {
        p = G.Vex[i].FirstArc;
        while (p != nullptr)
        {
            G.Vex[p->AdjVex].In_degree++;
            p = p->Next;
        }
    }
}



void Print_message()
{
    printf("学期总数 :  %d \t", G.mes->term_num);
    printf("每学期最大学分 ： %d \t", G.mes->max_credit);
    printf("必修课程数量 ：   %d \n", G.VexNum);

    cout << "\n\t\t\t本专业提供课程：\n";
    for (int i = 0; i < G.VexNum; i++)
    {
        printf("______________________________________________________________________\n");
        printf("课程号：C%d\t\t学分 ： %d\t\t先修课程： ", i + 1, G.Vex[i].credit);
        for (AdjVexNode* p = G.Vex[i].FirstArc; p != nullptr; p = p->Next)
            printf("C%d  ", p->AdjVex + 1);
        printf("\n");
    }

    cout << "\n\t\t\t按任意键回主菜单" << endl;
    getch();
    system("cls");
    mainmenu();
}


void Adjust_message()
{
    printf("允许修改的内容有: 1.学期总数  2.个人每学期最大学分 ");
    printf("\n\n请选择要修改的内容 ,或按其他键取消修改\n\n");
    char key = getch();
    key = key - '0';

    if (key == 1)
    {
        int term;
        printf("请输入学期总数：");
        scanf("%d", &term);
        fflush(stdin);				//清除键盘缓存
        if (term > MaxTerm || term < 1)
        {
            cout << "\n输入的学期数不合法 (大于最大允许的学期数 或 小于1 或 不是正整数)\n" << endl;
            cout << "请按任意键回主菜单" << endl;
            getch();
            system("cls");
            mainmenu();
        }
        G.mes->term_num = term;

        cout << "\n修改成功    (注：如果输入 数字+字符 那么只读入数字)\n" << endl;
        cout << "按任意键回主菜单" << endl;
        File_Update();			//更新文件信息
        getch();
    }
    else if (key == 2)
    {
        int credit;
        printf("请输入个人每学期最大学分：");
        scanf("%d", &credit);
        fflush(stdin);				//清除键盘缓存
        if (credit < 1 || credit > MaxCredit)
        {
            cout << "\n输入的学分数不合法 (小于1或大于30)\n" << endl;
            cout << "请按任意键回主菜单" << endl;
            getch();
            system("cls");
            mainmenu();
        }

        G.mes->max_credit = credit;
        cout << "\n修改成功    (如果输入 数字+字符 那么只读入数字)\n" << endl;
        cout << "按任意键回主菜单" << endl;
        File_Update();			//更新文件信息
        getch();
    }

    system("cls");
    mainmenu();

}



void File_Update()
{
    ofstream ofs;
    ofs.open("courses.txt", ios::in | ios::out | ios::binary);  // in | out 保持原内容不变

    ofs << G.mes->term_num << " " << G.mes->max_credit << " " << G.VexNum << "\n";
    ofs.close();
}


void Arrange_Select(int choice)
{
    Top_Sort(result1, 1);
    Top_Sort(result2, 2);			//调用4种拓扑排序，存到result 1~4
    Top_Sort(result3, 3);
    Top_Sort(result4, 4);
    Print_Top_Sort_Result();
    cout << "\n\n\n请输入你选择的课程安排先后顺序：";
    char key = getch();

    if (key == '1')
        Arrange(result1, choice);	//根据用户输入，确定使用哪种拓扑排序结果
    else if (key == '2')
        Arrange(result2, choice);
    else if (key == '3')
        Arrange(result3, choice);
    else if (key == '4')
        Arrange(result4, choice);

    else
    {
        cout << "\n\n选择有误，请按任意键回主菜单";
        getch();
        system("cls");
        mainmenu();
    }

}


void Arrange(VexNode* result, int choice)
{
    system("cls");
    FILE* fp = fopen("fruit.txt", "w");

    int arranged_num = 0;			//已经安排了的课程数
    int j;  				//控制循环的变量
    int k;					//控制循环的变量
    int course_num;				//本学期安排的课程总数
    int per_max_num;			//每学期最大允许课程总数
    int sumcredit;				//本学期已安排课程的总学分
    int tag;				//标志，用来判断即将安排到本学期的课程 是否有先修课程在本学期
    AdjVexNode* p;				//用来遍历 即将安排课程的邻接表 的指针

    if (choice == QUICKLY)
        per_max_num = G.VexNum;					//计算不同情况下的每学期最大课程数。
    else
    {
        if (G.VexNum % G.mes->term_num < G.mes->term_num / 2)
            per_max_num = G.VexNum / G.mes->term_num;
        else
            per_max_num = (G.VexNum / G.mes->term_num + 1);
    }

    VexNode *this_term_courses=new VexNode[per_max_num];  //存放本学期已经安排的课程

    for (k = 0; k < G.VexNum; k++)
    {
        if (arranged_num == G.VexNum)	break;

        fprintf(fp, "\n第%d个学期的课程为：", k + 1);
        printf("\n第%d个学期的课程为：", k + 1);
        sumcredit = 0;       			//本学期安排课程的总学分
        course_num = 0;	   			//本学期安排课程的总数
        p = result[arranged_num].FirstArc;  	//先修课指针
        tag = 0;         	   			//标志本学期是否有该课程的先修课程
        while (sumcredit + result[arranged_num].credit <= G.mes->max_credit && tag == 0 && course_num < per_max_num)
        {
            while (p != nullptr && tag == 0)
            {
                for (j = 0; j < course_num; j++)
                {
                    if (p->AdjVex == Locate(this_term_courses[j].data))
                    {
                        tag = 1;
                        break;
                    }
                }
                p = p->Next;
            }

            if (tag == 1) break;

            fprintf(fp, " %s ", result[arranged_num].data);
            printf(" %s ", result[arranged_num].data);
            sumcredit += result[arranged_num].credit;
            this_term_courses[course_num] = result[arranged_num];
            if (arranged_num == G.VexNum)	break;
            arranged_num++;
            course_num++;
            p = result[arranged_num].FirstArc;
        }

    }

    fclose(fp);

    if (k > G.mes->term_num)
    {
        fp = fopen("fruit.txt", "w");
        fprintf(fp, "%s%d", "该课程安排先后顺序下，此策略无解,因为安排所需学期数超过学期总数", G.mes->term_num);
        fclose(fp);
        cout << "\n\n\n该课程安排先后顺序下，此策略无解,因为安排所需学期数超过学期总数" << G.mes->term_num << endl;
        cout << "\n\n请按任意键回主菜单" << endl;
        getch();
        system("cls");
        mainmenu();
    }

    cout << "\n\n\n 课程安排信息已经存入当前目录下，“fruit.txt” \n\n请按任意键回主菜单";
    getch();
    system("cls");
    mainmenu();

}




void Top_Sort(VexNode* result, int choice)
{
    int i;						//循环控制变量
    int tag = 0;  					//判断图中还有没有入度为0的节点
    AdjVexNode* p;    				//指向选中课程邻接表域的指针
    stack<VexNode> S;     				//用来存储已被排序完的节点
    stack<AdjVexNode*> S1;				//用来存储每一层的节点的邻接表指针
    Read_file();					//读文件更新入度
    if (choice == 1)

        while (tag == 0)
        {
            tag = 1;
            for (i = G.VexNum - 1; i >= 0; i--)
                if (G.Vex[i].In_degree == 0)		//将一个层次的节点入栈S，同时邻接表头入栈S1
                {
                    S.push(G.Vex[i]);
                    G.Vex[i].In_degree--;
                    p = G.Vex[i].FirstArc;
                    S1.push(p);
                    tag = 0;
                }

            while (S1.empty() == false)		//一个层次的邻接点入度减一
            {
                p = S1.top();
                S1.pop();

                while (p != nullptr)
                {
                    G.Vex[p->AdjVex].In_degree--;
                    p = p->Next;
                }
            }
        }



    else if (choice == 2)

        while (tag == 0)
        {
            tag = 1;
            for (i = 0; i < G.VexNum; i++)
                if (G.Vex[i].In_degree == 0)
                {
                    S.push(G.Vex[i]);
                    G.Vex[i].In_degree--;
                    p = G.Vex[i].FirstArc;
                    S1.push(p);
                    tag = 0;
                }

            while (S1.empty() == false)
            {
                p = S1.top();
                S1.pop();

                while (p != nullptr)
                {
                    G.Vex[p->AdjVex].In_degree--;
                    p = p->Next;
                }
            }
        }



    else if (choice == 3)

        for (i = G.VexNum - 1; i >= 0; i--)
        {
            if (G.Vex[i].In_degree == 0)		//找到一个节点入度0就入栈并使邻接点入度减一
            {
                S.push(G.Vex[i]);
                G.Vex[i].In_degree--;
                p = G.Vex[i].FirstArc;
                while (p != nullptr)
                {
                    G.Vex[p->AdjVex].In_degree--;
                    p = p->Next;
                }

                i = G.VexNum;
            }
        }



    else

        for (i = 0; i < G.VexNum; i++)
        {
            if (G.Vex[i].In_degree == 0)
            {
                S.push(G.Vex[i]);
                G.Vex[i].In_degree--;
                p = G.Vex[i].FirstArc;
                while (p != nullptr)
                {
                    G.Vex[p->AdjVex].In_degree--;
                    p = p->Next;
                }

                i = -1;
            }
        }




    i = S.size();
    if (i < G.VexNum)		//查看节点是否都入栈了
    {
        cout << "拓扑排序失败，课程先修关系可能存在环路，请按任意键回主菜单\n";
        getch();
        system("cls");
        mainmenu();
    }

    for (i = 0; i < G.VexNum; i++)			//结果存到result数组
    {
        if (S.empty() == false)
        {
            result[i] = S.top();
            S.pop();
        }
        else
        {
            cout << "拓扑排序弹栈失败,请按任意键回主菜单" << endl;
            getch();
            mainmenu();
        }

    }
}



void Print_Top_Sort_Result()
{
    printf("各课程安排先后顺序为:\n");
    cout << "选择1：";
    for (int i = 0; i < G.VexNum; i++)
    {
        cout << result1[i].data << "  ";
    }

    cout << "\n\n选择2：";
    for (int i = 0; i < G.VexNum; i++)
    {
        cout << result2[i].data << "  ";
    }

    cout << "\n\n选择3：";
    for (int i = 0; i < G.VexNum; i++)
    {
        cout << result3[i].data << "  ";
    }

    cout << "\n\n选择4：";
    for (int i = 0; i < G.VexNum; i++)
    {
        cout << result4[i].data << "  ";
    }

}

