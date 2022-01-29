package ru.easydonate.easypayments.nms.proxy.v1_17_R1.interceptor;

import lombok.Getter;
import net.minecraft.commands.CommandListenerWrapper;
import net.minecraft.network.chat.ChatComponentText;
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.phys.Vec2F;
import net.minecraft.world.phys.Vec3D;
import ru.easydonate.easypayments.execution.interceptor.FeedbackInterceptor;

import java.util.List;

@Getter
public final class InterceptedCommandListenerWrapper extends CommandListenerWrapper implements FeedbackInterceptor {

    private static final Vec3D POSITION = new Vec3D(0D, 0D, 0D);
    private static final Vec2F DIRECTION = new Vec2F(0F, 0F);

    private final InterceptedCommandListener icommandlistener;

    public InterceptedCommandListenerWrapper(InterceptedCommandListener icommandlistener, WorldServer worldserver, String username, int permissionLevel) {
        super(icommandlistener, POSITION, DIRECTION, worldserver, permissionLevel, username, new ChatComponentText(username), worldserver.getMinecraftServer(), null);
        this.icommandlistener = icommandlistener;
    }

    @Override
    public List<String> getFeedbackMessages() {
        return icommandlistener.getFeedbackMessages();
    }

}
