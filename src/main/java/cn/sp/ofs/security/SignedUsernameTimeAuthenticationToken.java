package cn.sp.ofs.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class SignedUsernameTimeAuthenticationToken extends
		UsernamePasswordAuthenticationToken {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5282669761891231139L;
	private String requestSignature;

	/**
	 * Construct a new token instance with the given principal, credentials, and
	 * signature.
	 * 
	 * @param principal
	 *            the principal to use
	 * @param credentials
	 *            the credentials to use
	 * @param signature
	 *            the signature to use
	 */
	public SignedUsernameTimeAuthenticationToken(String principal,
			String credentials, String signature) {
		super(principal, credentials);
		this.requestSignature = signature;
	}

	public void setRequestSignature(String requestSignature) {
		this.requestSignature = requestSignature;
	}

	public String getRequestSignature() {
		return requestSignature;
	}
}
