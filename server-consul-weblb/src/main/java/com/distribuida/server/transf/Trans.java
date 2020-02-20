package com.distribuida.server.transf;

import java.nio.charset.Charset;

import com.distribuida.server.model.Album;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.reactivex.netty.channel.ContentTransformer;

public class Trans implements ContentTransformer<Album>{

	@Override
	public ByteBuf call(Album t1, ByteBufAllocator t2) {
		byte[] bytes = t1.toString().getBytes(Charset.defaultCharset());
        ByteBuf byteBuf = t2.buffer(bytes.length);
        byteBuf.writeBytes(bytes);
        return byteBuf;
	}
	
}
