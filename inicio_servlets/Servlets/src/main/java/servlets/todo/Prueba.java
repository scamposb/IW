package servlets.todo;

public class Prueba {
	private boolean isAValidDate(String date){
		try{
			int day = Integer.parseInt(date.substring(0, 2));
			int month = Integer.parseInt(date.substring(2,4));
			System.out.println("Day: "+day+" month: "+month);
			return !(day<1 || day>31 || month<1 || month>12 || date.length()>4);
			
		}catch(NumberFormatException e){
			return false;
		}
	}
	public static void main(String[] args) {
		System.out.println(new Prueba().isAValidDate("sssa"));

	}

}
