package com.ista.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ACTOR database table.
 * 
 */
@Entity
@NamedQuery(name="Actor.findAll", query="SELECT a FROM Actor a")
public class Actor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ACTOR_ID")
	@NonNull
	private long actorId;

	@Column(name="FIRST_NAME")
	@NonNull
	@Size(min=2, max=45)
	private String firstName;

	@Column(name="LAST_NAME")
	@NonNull
	@Size(max=45)
	private String lastName;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATE")
	private Date lastUpdate;

	//bi-directional many-to-one association to FilmActor
	@OneToMany(mappedBy="actor")
	private List<FilmActor> filmActors;

	public Actor() {
	}

	public long getActorId() {
		return this.actorId;
	}

	public void setActorId(long actorId) {
		this.actorId = actorId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<FilmActor> getFilmActors() {
		return this.filmActors;
	}

	public void setFilmActors(List<FilmActor> filmActors) {
		this.filmActors = filmActors;
	}

	public FilmActor addFilmActor(FilmActor filmActor) {
		getFilmActors().add(filmActor);
		filmActor.setActor(this);

		return filmActor;
	}

	public FilmActor removeFilmActor(FilmActor filmActor) {
		getFilmActors().remove(filmActor);
		filmActor.setActor(null);

		return filmActor;
	}

}