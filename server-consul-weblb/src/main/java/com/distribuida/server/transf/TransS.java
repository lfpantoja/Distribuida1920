package com.distribuida.server.transf;

import java.nio.charset.Charset;

import com.distribuida.server.model.Singer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.reactivex.netty.channel.ContentTransformer;

public class TransS implements ContentTransformer<Singer>{

	@Override
	public ByteBuf call(Singer t1, ByteBufAllocator t2) {
		byte[] bytes = t1.toString().getBytes(Charset.defaultCharset());
        ByteBuf byteBuf = t2.buffer(bytes.length);
        byteBuf.writeBytes(bytes);
        return byteBuf;
	}

}