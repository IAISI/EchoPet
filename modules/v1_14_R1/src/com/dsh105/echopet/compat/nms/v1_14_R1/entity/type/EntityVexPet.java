package com.dsh105.echopet.compat.nms.v1_14_R1.entity.type;

import com.dsh105.echopet.compat.api.entity.*;
import com.dsh105.echopet.compat.api.entity.type.nms.IEntityVexPet;
import com.dsh105.echopet.compat.nms.v1_14_R1.entity.EntityNoClipPet;

import net.minecraft.server.v1_13_R2.*;

/**
 * @Author Borlea
 * @Github https://github.com/borlea/
 * @Website http://codingforcookies.com/
 * @since Nov 19, 2016
 */
@EntitySize(width = 0.4F, height = 0.8F)
@EntityPetType(petType = PetType.VEX)
public class EntityVexPet extends EntityNoClipPet implements IEntityVexPet{

	protected static final DataWatcherObject<Byte> DATA = DataWatcher.a(EntityVexPet.class, DataWatcherRegistry.a);
	// Has the ability to have multiple settings.. but it seems to only use 1 for 'charged' which is 'attack mode'

	public EntityVexPet(World world){
		super(EntityTypes.VEX, world);
	}

	public EntityVexPet(World world, IPet pet){
		super(EntityTypes.VEX, world, pet);
	}

	protected void initDatawatcher(){
		super.initDatawatcher();
		getDataWatcher().register(DATA, (byte) 0);
	}

	private void a(int i, boolean flag){
		byte b0 = ((Byte) this.datawatcher.get(DATA)).byteValue();
		int j;
		if(flag){
			j = b0 | i;
		}else{
			j = b0 & (i ^ 0xFFFFFFFF);
		}
		this.datawatcher.set(DATA, Byte.valueOf((byte) (j & 0xFF)));
	}

	public boolean isPowered(){
		return b(1);// below method
	}

	private boolean b(int i){// just check EntityVex
		byte b0 = ((Byte) this.datawatcher.get(DATA)).byteValue();
		return (b0 & i) != 0;
	}

	public void setPowered(boolean flag){
		a(1, flag);
		// noClip(!flag);
	}

	@Override
	public SizeCategory getSizeCategory(){
		return SizeCategory.TINY;
	}
}
