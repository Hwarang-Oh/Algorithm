
// 기존에 있는 것들을 확장해서 새로운 내용을 더하거나, 기존 내용의 변경을 하기 위한 것이 상속
// 상속을 받고 아무것도 안하면, 할 필요가 없었던 것임. 
public class Engineer extends Employee{
	private String skill = "Java";

	public Engineer(String name) {
		super(name); // 2개 1개 다됨
		// TODO Auto-generated constructor stub
	}
	public Engineer(String name, int salary) {
		super(name, salary);
		// TODO Auto-generated constructor stub
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		if (skill == null)
			return;
		this.skill = skill;
	}
	
	public String getInfo() { // getInformation -> getInfo, 부모에 있는 것을 가져온 것 
//		return "name : " + getName() + ", salary : " + getSalary() + "원" + "skill : " + skill;
		return super.getInfo() + "skill : " + skill;
	}

	@Override
	public String toString() {
		return "Engineer [getName()=" + getName() + ", getSalary()=" + getSalary() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}	
}
