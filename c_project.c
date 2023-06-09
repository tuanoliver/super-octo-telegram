#include <stdio.h>
#include <string.h>
#include<stdlib.h>
#include<time.h>
#include<math.h>

#define CLASS_SIZE 50
#define MAXSUBJECT 32
#define MAXMARK 32
typedef struct
{
	char Unit_code[8];
	char Unit_title[32];
	float A1_mark;
	float A2_mark;
	float Exam_mark;
	//float Unit_total;
}unit_result_t;

typedef struct
{
	int Student_ID;
	char Last_name[32];
	char First_name[32];
	char Course_code[8];
	char Course_title[32];
	int Units_attempted;
	float Course_average;
	unit_result_t Unit[32];
	//unit_result_t Unit_s1_1[MAXMARK]; Unit_s2_2[MAXMARK]; Unit_s3_1[MAXMARK]; Unit_s3_1[MAXMARK]; Unit_s4_1[MAXMARK];Unit_s5_1[MAXMARK];
	//unit_result_t Unit_s1[MAXSUBJECT],Unit_s2[MAXSUBJECT],Unit_s3[MAXSUBJECT],Unit_s4[MAXSUBJECT],Unit_s5[MAXSUBJECT];
}course_record_t;  //student_t



void print_student(course_record_t student){
	int i;
	printf("Student information:\n");
	printf("Student-Id: = %d\n", student.Student_ID); 
	printf("\tlast_name:  %s\n", student.Last_name);
	printf("\tfirst_name:   %s\n", student.First_name);
	printf("\tcourse_code: %s\n", student.Course_code);
	printf("\tcourse title: %s\n", student.Course_title);
	printf("\tUnits_attempted: %d\n", student.Units_attempted);
	printf("\tCourse_average: %f\n", student.Course_average);
	for (i =0; i < 5; i++){
		printf("%s",student.Unit[i].Unit_code);
	};
}
	//printf("\t%d ", student.Unit.Unit_code);
	

	//printf("%s %s %f %f %f \n",studentcourse.Unit_s1.Unit_code,studentcourse.Unit_s1.Unit_title,studentcourse.Unit_s1.A1_mark,
	//studentcourse.Unit_s1.A2_mark,studentcourse.Unit_s1.Exam_mark);

int search_student(int studen_id, course_record_t studentcourse[], int total_num_students){
	// search and print the information of students whose same id as enter
	// studentcourse[]: an array of student structures
	// total_num_students: the number of students whose info are available in stu[]
  	
	int i, k=0;
	if (total_num_students<=0) 
		return 0;
	for (i=0; i<total_num_students; i++) {
		if(studentcourse[i].Student_ID == studen_id) {
			 print_student(studentcourse[i]);
		}
		k++;
	}
	printf("\nin function k=%d\n", k);
	return k;

}

int main()
{
	
	int studen_id;
	int total_num_students = 5,i,j;
	course_record_t studentcourse[CLASS_SIZE]= {
												{10468163, 
												"Mg", 
												"Macsq",
												"U68",
												"Computer Science",
												1,
												89,
												{{"CSP2151","Programming Fundamentals",19,25,45}
												}
												},
												
												{10321615, 
												"Lk", 
												"Xasd",
												"U69",
												"Data Science",
												2,
												60.5,
												{{"CSP2151","Programming Fundamentals",20,10,11},
												{"CSP2348","Data Structures",15,25,40}
												}
												},
												
												{10655191,
												"Ng",
												"Macs",
												"U67",
												"Information technology",
												3,
												66.03,
												{{"CSP2151","Programming Fundamentals",16,18,44.4},
												{"CSP2348","Data Structures",10,21.5,43.2},
												{"CSI3344","Distributed System",19,28,18}
												}
												},
												
												{10655192,
												"Mkl",
												"Lgh",
												"U70",
												"Cyber Security",
												4,
												59.65,
												{{"CSP2151","Programming Fundamentals",17,19,43.2},
												{"CSP2348","Data Structures",11,25.3,44.2},
												{"CSI3344","Distributed System",18,29,17},
												{"CSI1105","Applied Communication",4.0,0.1,10.8}
												}
												},
												
												{10655193,
												"Dfg",
												"Poi",
												"U71",
												"Computer Media",
												5,
												65.28,
												{{"CSP2151","Programming Fundamentals",16.5,17,44.2},
												{"CSP2348","Data Structures",11,22.5,44.2},
												{"CSI3344","Distributed System",20,29.5,17.5},
												{"CSI1105","Applied Communication",2.0,0.0,10.5},
												{"CSI2132","Enterprise Data",18.5,27.5,45.5}
												}
												}
	};
												
	for (i=0; i<5; i++){
		printf("studen_id: %d\n", studentcourse[i].Student_ID);
		printf("lastname : %s\n", studentcourse[i].Last_name);
		printf("firstname : %s\n", studentcourse[i].First_name);
		printf("firstname : %s\n", studentcourse[i].Course_code);
		printf("firstname : %s\n", studentcourse[i].Course_title );
		printf("firstname : %d\n", studentcourse[i].Units_attempted );
		printf("firstname : %f\n", studentcourse[i].Course_average );
		printf("\nunit_code | unit_title | A1_mark  | A2_mark  |Exam_mark\n" );

		printf("----------------------------------------------------");


		printf ("\n%d, %s, %s, %s, %s, %d, %f\n",studentcourse[i].Student_ID, studentcourse[i].Last_name, studentcourse[i].First_name, studentcourse[i].Course_code, studentcourse[i].Course_title,studentcourse[i].Units_attempted,studentcourse[i].Course_average);
			for (j= 0; j < studentcourse[i].Units_attempted; j++){
				printf("\n%s\n",studentcourse[j].Unit[j].Unit_code);
			}
	};
												
	int k=0;
	printf("\nEnter Student id:\n");
	scanf("%d", &studen_id);
	k= search_student(studen_id,studentcourse, total_num_students);
	//printf("student with id %d %d", k,studen_id );
	//if studentcourse.Units_attempted = studentcourse.Unit_s1
	printf("k=%d\n", k);
	float unit_marks[32];
	printf("Units_attempted= %d\n", studentcourse[k].Units_attempted);
	for (i=0; i<studentcourse[k].Units_attempted; i++){
		unit_marks[i]= studentcourse[k].Unit[i].A1_mark +studentcourse[k].Unit[i].A2_mark +studentcourse[k].Unit[i].Exam_mark;
	};
	printf("\n\nünit_mark[]\n");
	for (i=0; i<studentcourse[k].Units_attempted; i++){
		printf("Unit_marks[%d] =%7.2f\n", i, unit_marks[i]);

	};
	
	return 0;
}


















/*{10321615, "Lk", "Xasd","U69","Data Science",2,60.5},
												{10655191,"Ng","Macs","U67","Information technology",3,66.03},
												{10655192,"Mkl","Lgh","U70","Cyber Security",4,59.65},
												{10655193,"Dfg","Poi","U71","Computer Media",5,65.28}};*/
											  
	/*unit_result_t Unit_s1[MAXSUBJECT]={{"CSP2151","Programming Fundamentals",19,25,45}};
	unit_result_t Unit_s1_1[MAXMARK]		 ={{89}};
	
	unit_result_t Unit_s2[MAXSUBJECT]={{"CSP2151","Programming Fundamentals",20,10,11},
									   {"CSP2348","Data Structures",15,25,40}};
	unit_result_t Unit_s2_2[MAXMARK]		={{41,80}};				
	unit_result_t Unit_s3[MAXSUBJECT]={{"CSP2151","Programming Fundamentals",16,18,44.4},
									   {"CSP2348","Data Structures",10,21.5,43.2},
									   {"CSI3344","Distributed System",19,28,18}};
	unit_result_t Unit_s3_1[MAXMARK]={{78.4,74.7,45}};
	unit_result_t Unit_s4[MAXSUBJECT]={{"CSP2151","Programming Fundamentals",17,19,43.2},
									   {"CSP2348","Data Structures",11,25.3,44.2},
									   {"CSI3344","Distributed System",18,29,17},
									   {"CSI1105","Applied Communication",4.0,0.1,10.8}};
	unit_result_t Unit_s4_1[MAXMARK]={{79.2,80.5,64,14.9}};					
	unit_result_t Unit_s5[MAXSUBJECT]={{"CSP2151","Programming Fundamentals",16.5,17,44.2},
									   {"CSP2348","Data Structures",11,22.5,44.2},
									   {"CSI3344","Distributed System",20,29.5,17.5},
									   {"CSI1105","Applied Communication",2.0,0.0,10.5},
									   {"CSI2132","Enterprise Data",18.5,27.5,45.5}};
	unit_result_t Unit_s5_1[]={{77.7,77.7,67,12.5,91.5}};	*/							   
									   
	//printf("%d\n", studentcourse[0].Student_ID);
	//printf("%s\n", studentcourse[0].Last_name);
	//printf("%s\n", studentcourse[0].Course_code);
	//printf("%s\n", studentcourse[0].Course_title);
	//printf("%s %s %f %f %f   \n", unit5[0].Unit_code, unit5[0].Unit_title,unit5[0].A1_mark,unit5[0].A2_mark,unit5[0].Exam_mark);
	
	
	//printf("%s %s %f %f %f   \n", unit1[0].Unit_code, unit1[0].Unit_title,unit1[0].A1_mark,unit1[0].A2_mark,unit1[0].Exam_mark);
	//printf("%s %s %f %f %f   \n", Unit_s1[0].Unit_code, Unit_s1[0].Unit_title,Unit_s1[0].A1_mark,Unit_s1[0].A2_mark,Unit_s1[0].Exam_mark);
	// show all student information
	
	//for (i=0; i<total_num_students; i++)
	//print_student(studentcourse[i]);