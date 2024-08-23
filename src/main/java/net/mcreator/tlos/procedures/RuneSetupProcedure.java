package net.mcreator.tlos.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.scores.Team;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

@EventBusSubscriber
public class RuneSetupProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (world instanceof Level _level)
			_level.getScoreboard().addPlayerTeam("cryonis");
		if (world instanceof Level _level) {
			PlayerTeam _pt = _level.getScoreboard().getPlayerTeam("cryonis");
			if (_pt != null)
				_pt.setNameTagVisibility(Team.Visibility.HIDE_FOR_OTHER_TEAMS);
		}
		if (world instanceof Level _level)
			_level.getScoreboard().addPlayerTeam("stasis");
		if (world instanceof Level _level) {
			PlayerTeam _pt = _level.getScoreboard().getPlayerTeam("stasis");
			if (_pt != null)
				_pt.setNameTagVisibility(Team.Visibility.HIDE_FOR_OTHER_TEAMS);
		}
		if (world instanceof Level _level)
			_level.getScoreboard().addPlayerTeam("magnesis");
		if (world instanceof Level _level) {
			PlayerTeam _pt = _level.getScoreboard().getPlayerTeam("magnesis");
			if (_pt != null)
				_pt.setNameTagVisibility(Team.Visibility.HIDE_FOR_OTHER_TEAMS);
		}
		if (world instanceof Level _level)
			_level.getScoreboard().addPlayerTeam("remote_bomb");
		if (world instanceof Level _level) {
			PlayerTeam _pt = _level.getScoreboard().getPlayerTeam("remote_bomb");
			if (_pt != null)
				_pt.setNameTagVisibility(Team.Visibility.HIDE_FOR_OTHER_TEAMS);
		}
		if (world instanceof Level _level)
			_level.getScoreboard().addPlayerTeam("master_cycle");
		if (world instanceof Level _level) {
			PlayerTeam _pt = _level.getScoreboard().getPlayerTeam("master_cycle");
			if (_pt != null)
				_pt.setNameTagVisibility(Team.Visibility.HIDE_FOR_OTHER_TEAMS);
		}
	}
}
