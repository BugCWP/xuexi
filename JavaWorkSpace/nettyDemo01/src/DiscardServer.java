
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.io.IOException;

public class DiscardServer {
    private int port;

    public DiscardServer(int port){
        this.port=port;
    }

    public void run() throws Exception{
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup workGroup=new NioEventLoopGroup();
        System.out.println("准备运行端口"+port);
        try{
            ServerBootstrap b=new ServerBootstrap();
            b=b.group(bossGroup,workGroup);
            b=b.channel(NioServerSocketChannel.class);
            b=b.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new DiscardServerHandler());
                }
            });
            b=b.option(ChannelOption.SO_BACKLOG,128);
            b=b.childOption(ChannelOption.SO_KEEPALIVE,true);
            ChannelFuture f= null;
                f = b.bind(port).sync();
                f.channel().closeFuture().sync();
        }finally {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception{
        int port;
        if (args.length>0){
            port=Integer.parseInt(args[0]);
        }else {
            port=8080;
        }
        new DiscardServer(port).run();
        System.out.println("server:run()");
    }
}
