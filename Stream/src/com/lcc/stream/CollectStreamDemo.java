package com.lcc.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: lcc
 * @Date: 2018-05-14
 **/

public class CollectStreamDemo {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("lin", 10, Gender.MALE, Grade.ONE),
				new Student("lin1", 9, Gender.MALE, Grade.THREE),
				new Student("lin2", 8, Gender.FEMALE, Grade.TWO),
				new Student("lin3", 13, Gender.FEMALE, Grade.FOUR),
				new Student("lin4", 7, Gender.FEMALE, Grade.THREE),
				new Student("lin5", 13, Gender.MALE, Grade.ONE),
				new Student("lin6", 13, Gender.FEMALE, Grade.THREE),
				new Student("lin7", 9, Gender.FEMALE, Grade.TWO),
				new Student("lin8", 6, Gender.MALE, Grade.ONE),
				new Student("lin9", 6, Gender.MALE, Grade.ONE),
				new Student("lin10", 14, Gender.FEMALE, Grade.FOUR),
				new Student("lin11", 13, Gender.MALE, Grade.FOUR));

		//得到所有学生年龄列表
		//s -> s.getAge()  ---> Student::getAge 不会多生成一个类似lambda$0函数
		//List<Integer> ageList = students.stream().map(s -> s.getAge()).collect(Collectors.toList());
		List<Integer> ageList = students.stream().map(Student::getAge).collect(Collectors.toList());
		System.out.println("年纪" + ageList);

		//统计汇总信息
		IntSummaryStatistics agesSum = students.stream().collect(Collectors.summarizingInt(Student::getAge));
		System.out.println("年龄" + agesSum);

		//分块
		Map<Boolean, List<Student>> genders = students.stream().collect(Collectors.partitioningBy(s -> s.getGender() == Gender.MALE));
		System.out.println("男女生列表" + genders);

		//分组
		Map<Grade, List<Student>> g = students.stream().collect(Collectors.groupingBy(Student::getGrade));
		System.out.println("班级列表" + g);

		//得到所有班级学生个数

		Map<Grade, Long> gc = students.stream().collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()));
		System.out.println("班级数" + gc);
	}
}

class Student {

	private String name;


	private int age;

	private Gender gender;


	private Grade grade;

	public Student(String name, int age, Gender gender, Grade grade) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + ", gender=" + gender
				+ ", grade=" + grade + "]";
	}

}


enum Gender {
	MALE, FEMALE
}


enum Grade {
	ONE, TWO, THREE, FOUR;
}