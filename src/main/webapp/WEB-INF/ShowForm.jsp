<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="beans.Adresse"  %>

		<div id="form">
		<c:choose>
		<c:when test="${adresse != null}">
			Edition
			<form action="/carnetAdresse/main/edit/" method="post">
		</c:when>
		<c:otherwise>
			Ajout
			<form action="/carnetAdresse/main/add/" method="post">
		</c:otherwise>
		</c:choose>
		<table>
		<tbody>
		<tr>
		<td>Id</td>
			<td style="background: grey"><input readonly name="id" type="text" value="${adresse != null ? adresse.getId() : '-1' }"></td>
		</tr>
		<tr>
		<td>Nom</td>
			<td><input name="nom" type="text" value="${adresse != null ? adresse.getNom() : '' }"></td>
		</tr>
		<tr>
		<td>Prenom</td>
			<td><input name="prenom" type="text" value="${adresse != null ? adresse.getPrenom() : '' }" ></td>
		</tr>
		<tr>
		<td>Téléphone</td>
			<td><input name="tel" type="text" value="${adresse != null ? adresse.getTel() : '' }" ></td>
		</tr>
		<tr>
		<td>Rue</td>
			<td><input name="rue" type="text" value="${adresse != null ? adresse.getRue() : '' }" ></td>
		</tr>
		<tr>
		<td>Code postal</td>
			<td><input name="codePostal" type="text" value="${adresse != null ? adresse.getCodePostal() : '' }" ></td>
		</tr>
		<tr>
		<td>Ville</td>
			<td><input name="ville" type="text" value="${adresse != null ? adresse.getVille() : '' }" ></td>
		</tr>
		<tr>
		<td>Pays</td>
			<td><input name="pays" type="text" value="${adresse != null ? adresse.pays : '' }" ></td>
		</tr>
		</tbody>
		</table>
			<input type="submit" name="validation" value="Valider ${adresse != null ? 'Edition' : 'Ajout' }">

		<input type="submit" name="annulation" value="Annuler">
		</form>
		</div>