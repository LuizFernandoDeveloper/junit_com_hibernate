package enums;

public enum CarColor {
	BLACK("#FA0F02"),
	SILVER("#FA0F02"), 
	RED("#FA0F02"), 
	GRAY("#FA0F02"),
	BLUE("#FA0F02"),
	WHITE("#FA0F02"),
	STEEL("#FA0F02");
	
	private final String hexadecimalColorCode;
	
	CarColor(String hexadecimalColorCode) {
		
		this.hexadecimalColorCode = hexadecimalColorCode;
		
	}
	
	public String getHexadecimalColorCode() {
		
		return hexadecimalColorCode;
		
	}
	
}
