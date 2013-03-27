package com.spring.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.BitSet;

public class Encoder {

	public String encode(String s) {

		byte byte0 = 10;

		byte[] bString = s.getBytes();

		StringBuffer stringbuffer = new StringBuffer(bString.length);

		ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(
				byte0);

		OutputStreamWriter outputstreamwriter = new OutputStreamWriter(
				bytearrayoutputstream);

		int mValue = 0;

		for (int i = 0; i < bString.length; i++)

		{

			char c = (char) bString[i];

			mValue = (bString[i] < 0) ? bString[i] + 256 : bString[i];

			// if(mValue > 127){ //2byte

			// stringbuffer.append(Integer.toHexString(c));

			// }

			// else{

			if (dontNeedEncoding.get(c))

			{

				stringbuffer.append(Integer.toHexString(c));

				continue;

			}

			try

			{

				outputstreamwriter.write(c);

				outputstreamwriter.flush();

			}

			catch (IOException _ex)

			{

				bytearrayoutputstream.reset();

				continue;

			}

			byte abyte0[] = bytearrayoutputstream.toByteArray();

			for (int j = 0; j < abyte0.length; j++)

			{

				char c1 = Character.forDigit(abyte0[j] >> 4 & 0xf, 16);

				if (Character.isLetter(c1))

					c1 -= ' ';

				stringbuffer.append(c1);

				c1 = Character.forDigit(abyte0[j] & 0xf, 16);

				if (Character.isLetter(c1))

					c1 -= ' ';

				stringbuffer.append(c1);

			}

			bytearrayoutputstream.reset();

			// }

		}

		return stringbuffer.toString();

	}

	static BitSet dontNeedEncoding;

	static final int caseDiff = 32;

	static

	{

		dontNeedEncoding = new BitSet(256);

		for (int i = 97; i <= 122; i++)

			dontNeedEncoding.set(i);

		for (int j = 65; j <= 90; j++)

			dontNeedEncoding.set(j);

		for (int k = 48; k <= 57; k++)

			dontNeedEncoding.set(k);

		dontNeedEncoding.set(32);

		dontNeedEncoding.set(45);

		dontNeedEncoding.set(95);

		dontNeedEncoding.set(46);

		dontNeedEncoding.set(42);

	}

	public static String decode(String cEncodeString) {

		StringBuffer stringbuffer = new StringBuffer(cEncodeString.length() / 2);

		for (int i = 0; i < cEncodeString.length(); i = i + 2) {

			stringbuffer.append((char) Integer.parseInt(cEncodeString
					.substring(i, i + 2), 16));

		}

		return stringbuffer.toString();

	}

}
