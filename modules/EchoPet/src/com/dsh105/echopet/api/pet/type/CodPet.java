package com.dsh105.echopet.api.pet.type;

import com.dsh105.echopet.compat.api.entity.EntityPetType;
import com.dsh105.echopet.compat.api.entity.PetType;
import com.dsh105.echopet.compat.api.entity.type.pet.ICodPet;
import org.bukkit.entity.Player;

@EntityPetType(petType = PetType.COD)
public class CodPet extends FishPet implements ICodPet{
	
	public CodPet(Player owner){
		super(owner);
	}
}
