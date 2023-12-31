package enums;

public enum Brand {
	
	DODGE_RAM(
			
			"Ram 1500 Rebel", 
			"Ram 2500", 
			"Ram 3500"
			
			),
	CHECROLET(
			
			"Montana", 
			"Silverado", 
			"S10"
			
			),
	FORD(
			"Nova Geração Ranger", 
			"Ranger Raptor", 
			"Maverick", 
			"Maverick Hybrid", 
			"F-150"
			
			),
	TOYOTA(
			
			"Hilux Cabine Dupla STD Power Pack",
			"Hilux Cabine Dupla SR",
			"Hilux Cabine Dupla SRV", 
			"Hilux Cabine Dupla SRX", 
			"Hilux Cabine Dupla SRX Plus", 
			"Hilux Cabine Dupla GR-Sport" , 
			"Hilux Cabine Simples e chassi",
			"Hilux Cabine Simples"
			
			),
	MITSUBISHI(
			
			"Pajero Sport", 
			"Eclipse Cross", 
			"Eclipse Cross Sport", 
			"L200 Triton Sport", 
			"L200 Triton Outdoor", 
			"L200 Triton Savana", 
			"L200 Triton Sertões", 
			"L200 Triton GLS", 
			"L200 Triton GL"
			
			);
	
	private String[] carModels;
	
	Brand(String... carModel ) {
		
		this.carModels = carModel;
		
	}
	
	public String[] getCarModels() {
		
		return carModels;
		
	}
	
	public String getCarModelsById(int id) {
		
		return carModels[id];
		
	}
	
	public String getCarModelsByName(String carModelName) {
		
		for(String model : carModels) {
			
			
			if(model.equals(carModelName)) {
				
				return model;
				
			}
		}
		
		return null;
	}
}
