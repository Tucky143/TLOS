
package net.mcreator.tloa.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class SheikahStoneSlabBlock extends SlabBlock {
	public SheikahStoneSlabBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.BASALT).strength(4.5f, 10f).requiresCorrectToolForDrops());
	}
}
