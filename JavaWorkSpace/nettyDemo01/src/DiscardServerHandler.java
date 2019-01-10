import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;


public class DiscardServerHandler extends ChannelHandlerAdapter {
    //接受信息
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
////        try{
////            ByteBuf in=(ByteBuf)msg;
////                while (in.isReadable()){
////                    System.out.println((char) in.readByte());
////                    System.out.flush();
////                }
////        }finally {
////            ReferenceCountUtil.release(msg);
////        }
//        ctx.writeAndFlush(msg);
//    }


    //构建发送一个信息
    //连接被建立并且准备通信时调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
       final ByteBuf time=ctx.alloc().buffer(4);
       time.writeInt((int)(System.currentTimeMillis()/1000L+2208988800L));
       final ChannelFuture f=ctx.writeAndFlush(time);
       f.addListener(new ChannelFutureListener() {
           @Override
           public void operationComplete(ChannelFuture channelFuture) throws Exception {
               assert  f==channelFuture;
               ctx.close();
           }
       });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
