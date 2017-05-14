/**
 * Copyright (C) 2016 - 2017 youtongluan.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.yx.http.handler;

import org.yx.http.Web;
import org.yx.util.secury.EncryUtil;

/**
 * base64解码
 * 
 * @author 游夏
 *
 */
public class AesDecodeHandler implements HttpHandler {

	@Override
	public boolean accept(Web web) {
		return web.requestEncrypt().isAes();
	}

	@Override
	public boolean handle(WebContext ctx) throws Exception {
		if (ctx.getHttpNode().argClz == null) {
			return false;
		}
		byte[] bs = (byte[]) ctx.getData();
		byte[] key = ctx.getKey();
		byte[] data = EncryUtil.decrypt(bs, key);
		ctx.setData(data);
		return false;
	}

}
