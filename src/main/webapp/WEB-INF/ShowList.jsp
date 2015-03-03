<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="list">
	<c:forEach var="e" items="${erreurs}">
		<p style="color: red">${e}</p>
	</c:forEach>

	<c:forEach var="m" items="${messages}">
		<p style="color: green">${m}</p>
	</c:forEach>
	<table>
		<thead>
			<tr>
				<td>Id</td>
				<td>Nom</td>
				<td>Prenom</td>
				<td>Téléphone</td>
				<td>Rue</td>
				<td>Code postal</td>
				<td>Ville</td>
				<td>Pays</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="a" items="${adresses}">
				<tr>
					<td>${a.getId()}</td>
					<td>${a.nom}</td>
					<td>${a.prenom}</td>
					<td>${a.tel}</td>
					<td>${a.rue}</td>
					<td>${a.codePostal}</td>
					<td>${a.ville}</td>
					<td>${a.pays}</td>
					<td><a href="/carnetAdresse/main/show/${a.id}">Afficher/Modifier</a>
						<a href="/carnetAdresse/main/delete/${a.id}">Supprimer</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form method="get" action="/carnetAdresse/main/new">
		<input type="submit" value="Ajouter une entrée">
	</form>
</div>