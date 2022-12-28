package it.prova.pizzastore_backend.security.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.prova.pizzastore_backend.security.JWTUtil;
import it.prova.pizzastore_backend.security.dto.UtenteAuthDTO;
import it.prova.pizzastore_backend.service.UtenteService;



@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private JWTUtil jwtUtil;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private UtenteService utenteService;

	@PostMapping("/login")
	public Map<String, Object> loginHandler(@RequestBody UtenteAuthDTO body) {
		try {
			// Creating the Authentication Token which will contain the credentials for
			// authenticating
			// This token is used as input to the authentication process
			UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(
					body.getUsername(), body.getPassword());
				
			// Authenticating the Login Credentials
			authManager.authenticate(authInputToken);
						
			// Se siamo qui posso tranquillamente generare il JWT Token
			String token = jwtUtil.generateToken(body.getUsername());

			// Respond with the JWT
			//return Collections.singletonMap("jwt-token", token);
			Map<String, Object> result =  new HashMap<String, Object>();
			result.put("jwt-token", token);
			result.put("ruoli", utenteService.findByUsername(body.getUsername()).getRuoli().stream().map(r -> r.getDescrizione()).collect(Collectors.toList()));
			return result;
		} catch (AuthenticationException authExc) {
			// Auhentication Failed
			throw new RuntimeException("Invalid Login Credentials");
		}
	}
}
