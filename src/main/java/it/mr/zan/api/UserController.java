package it.mr.zan.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import it.mr.zan.model.User;
import it.mr.zan.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/users")
@Api(description = "operazioni sull'entità User")
class UserController {

	@Autowired
	private UserRepository repository;

	@ApiOperation("Ritorna un utente")
	@GetMapping("/{id}")
	User get(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException());
	}

	@ApiOperation(value = "Ritorna tutti gli utenti registrati"
		, responseContainer = "List"
		, produces = "application/json"
		, response = User.class)
	@GetMapping("")
	Iterable<User> find() {
		return repository.findAll();
	}

	@ApiOperation("Crea un nuovo utente")
	@PostMapping("")
	User add(@Valid @RequestBody User user) {
		return repository.save(user);
	}

	@ApiOperation("Aggiorna i dati di un utente")
	@PutMapping("/{id}")
	User update(@Valid @RequestBody User user, @PathVariable Long id) {

		return repository.findById(id).map(u -> {
			u.setFirstName(user.getFirstName());
			u.setLastName(user.getLastName());
			u.setEmail(user.getEmail());
			return repository.save(u);
		}).orElseThrow(() -> new NotFoundException());
	}

	@ApiOperation("Rimuove un utente")
	@DeleteMapping("/{id}")
	void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}