
package net.mcreator.tloa.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class GlowingSheikahPlateBlock extends Block {
	public GlowingSheikahPlateBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.BASALT).strength(4.5f, 10f).lightLevel(s -> 12).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
