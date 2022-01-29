package ru.easydonate.easypayments.nms.proxy.v1_18_R1.interceptor;

import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_18_R1.command.ProxiedNativeCommandSender;
import ru.easydonate.easypayments.execution.interceptor.FeedbackInterceptor;

import java.util.List;

final class InterceptedProxiedSender extends ProxiedNativeCommandSender implements FeedbackInterceptor {

    public InterceptedProxiedSender(InterceptedCommandListenerWrapper orig, CommandSender sender) {
        super(orig, sender, sender);
    }

    @Override
    public InterceptedCommandListenerWrapper getHandle() {
        return (InterceptedCommandListenerWrapper) super.getHandle();
    }

    @Override
    public List<String> getFeedbackMessages() {
        return getHandle().getFeedbackMessages();
    }

}
