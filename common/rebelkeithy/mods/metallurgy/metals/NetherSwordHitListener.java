package rebelkeithy.mods.metallurgy.metals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import rebelkeithy.mods.metallurgy.core.metalsets.ISwordHitListener;

public class NetherSwordHitListener implements ISwordHitListener
{
	private static int speed = 1;
	private static int slowness = 2;
	private static int haste = 3;
	private static int fatigue = 4;
	private static int strength = 5;
	private static int health = 6;
	private static int damage = 7;
	private static int jump = 8;
	private static int nausea = 9;
	private static int regen = 10;
	private static int resistance = 11;
	private static int fireResist = 12;
	private static int waterBreathing = 13;
	private static int invisibility = 14;
	private static int blindness = 15;
	private static int nightVision = 16;
	private static int hunger = 17;
	private static int weakness = 18;
	private static int poison = 19;
	private static int wither = 20;

	@Override
	public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving player) {

		if(Math.random() < 0.7)
			return false;
		
		if(itemstack.getItem().itemID == MetallurgyMetals.netherSet.getOreInfo("Ignatius").sword.itemID)
		{
			entityliving.setFire(2);
		}
		else if(itemstack.getItem().itemID == MetallurgyMetals.netherSet.getOreInfo("Shadow Iron").sword.itemID)
		{
			entityliving.addPotionEffect(new PotionEffect(weakness, 80, 0));
		}
		else if(itemstack.getItem().itemID == MetallurgyMetals.netherSet.getOreInfo("Vyroxeres").sword.itemID)
		{
			entityliving.addPotionEffect(new PotionEffect(poison, 80, 0));
		}
		else if(itemstack.getItem().itemID == MetallurgyMetals.netherSet.getOreInfo("Ceruclase").sword.itemID)
		{
			entityliving.addPotionEffect(new PotionEffect(slowness, 80, 0));
		}
		else if(itemstack.getItem().itemID == MetallurgyMetals.netherSet.getOreInfo("Kalendrite").sword.itemID)
		{
			player.addPotionEffect(new PotionEffect(regen, 80, 0));
		}
		else if(itemstack.getItem().itemID == MetallurgyMetals.netherSet.getOreInfo("Vulcanite").sword.itemID)
		{
			entityliving.setFire(4);
		}
		else if(itemstack.getItem().itemID == MetallurgyMetals.netherSet.getOreInfo("Sanguinite").sword.itemID)
		{
			entityliving.addPotionEffect(new PotionEffect(wither, 80, 0));
		}
		else if(itemstack.getItem().itemID == MetallurgyMetals.netherSet.getOreInfo("Shadow Steel").sword.itemID)
		{
			entityliving.addPotionEffect(new PotionEffect(weakness, 80, 1));
		}
		else if(itemstack.getItem().itemID == MetallurgyMetals.netherSet.getOreInfo("Inolashite").sword.itemID)
		{
			entityliving.addPotionEffect(new PotionEffect(poison, 80, 0));
			entityliving.addPotionEffect(new PotionEffect(slowness, 80, 0));
		}
		else if(itemstack.getItem().itemID == MetallurgyMetals.netherSet.getOreInfo("Amordrine").sword.itemID)
		{
			player.heal(3);
		}
		
		return false;
	}
	
	@ForgeSubscribe
	public void onDeathEvent(LivingDeathEvent event)
	{
		if(event.source.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			if(player.getCurrentEquippedItem() == null)
				return;

			if(player.getCurrentEquippedItem().itemID == MetallurgyMetals.netherSet.getOreInfo("Midasium").sword.itemID)
			{
				try 
				{
					Method m = EntityLiving.class.getDeclaredMethod("dropFewItems", Boolean.TYPE, Integer.TYPE);
					m.setAccessible(true);
					m.invoke(event.entityLiving, (Boolean)true, (Integer)0);
					//m.setAccessible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
