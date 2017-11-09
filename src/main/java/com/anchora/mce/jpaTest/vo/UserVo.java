package com.anchora.mce.jpaTest.vo;

public class UserVo {
	private Long id;
	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", age=" + age + "]";
	}

}
