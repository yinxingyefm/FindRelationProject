package pdsu.dqw.util;

import java.security.Key;
import java.util.Date;
 
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
 
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {
	public static String sercetKey = "InMySchoolOnline";
	/**
	 * 代表token的有效时间
	 */
	public final static long keeptime = 1800000;
	
	
	public static String generToken(String id, String issuer, String subject) {
		long ttlMillis = keeptime;
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		//使用Hash256算法进行加密
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		//获取系统时间以便设置token有效时间
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(sercetKey);
		//将密钥转码为base64形式,再转为字节码
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		//对其使用Hash256进行加密
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now);
		//JWT生成类,此时设置iat,以及根据传入的id设置token
		if (subject != null) {
			builder.setSubject(subject);
		}
		if (issuer != null) {
			builder.setIssuer(issuer);
		}
		//由于Payload是非必须加入的,所以这时候要加入检测
		builder.signWith(signatureAlgorithm, signingKey);
		//进行签名,生成Signature
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		//返回最终的token结果
		return builder.compact();
	}
	/**
	 * 该函数用于更新token
	 */
	public static String updateToken(String token) {
		//Claims就是包含了我们的Payload信息类
		Claims claims = verifyToken(token);
		String id = claims.getId();
		String subject = claims.getSubject();
		String issuer = claims.getIssuer();
		//生成新的token,根据现在的时间
		return generToken(id, issuer, subject);
	}
	/**
	 * 将token解密出来,将payload信息包装成Claims类返回
	 */
	private static Claims verifyToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(sercetKey))
				.parseClaimsJws(token).getBody();
		return claims;
	}
}
