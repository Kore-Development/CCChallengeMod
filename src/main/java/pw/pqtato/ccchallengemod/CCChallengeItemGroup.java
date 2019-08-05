package pw.pqtato.ccchallengemod;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import pw.pqtato.ccchallengemod.lists.ItemList;

public class CCChallengeItemGroup extends ItemGroup {
	public CCChallengeItemGroup() {
		super("ccchallenge");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.icon);
	}
}
