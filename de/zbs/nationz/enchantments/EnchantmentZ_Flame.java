package de.zbs.nationz.enchantments;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import de.zbs.nationz.api.Item;

public class EnchantmentZ_Flame extends EnchantmentZ {

	private Listener ls = new Listener() {
		@EventHandler
		public void onDamae(EntityDamageByEntityEvent e) {
			if (e.getDamager() instanceof Player) {
				Player p = (Player) e.getDamager();
				Item es  = Item.get(p.getEquipment().getItemInMainHand());
				if (es.hasEnchantment(FLAME)) {
					e.getEntity().setFireTicks(es.getEnchantmentLevel(FLAME) * 20);
				}
			}
		}
	};

	@Override
	public boolean conflictsWith(EnchantmentZ arg0) {
		return false;
	}

	@Override
	public List<Material> getItemTarget() {
		return new ItemTarget().BOW;
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public String getName() {
		return "Flame";
	}

	@Override
	public Material getIcon() {
		return Material.NETHERRACK;
	}

	@Override
	public Listener getListener() {
		return ls;
	}

	@Override
	public Enchantment vanillaEnchant() {
		return null;
	}

	@Override
	public ItemStack[] craftingIngredients() {
		return new ItemStack[] {
				new ItemStack(Material.FLINT_AND_STEEL, 4),
				new ItemStack(Material.MAGMA_CREAM, 4),
				new ItemStack(Material.NETHERRACK, 128)
		};
	}
}