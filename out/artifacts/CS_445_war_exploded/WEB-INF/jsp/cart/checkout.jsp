<%@ page session="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp"/>

<body>

<div class="container" role="main">

    <div class="col-sm-4">
        <jsp:include page="../fragments/leftbar.jsp"/>
    </div>
    <div class="col-sm-8">
        <c:if test="${not empty msg}">
            <div class="alert alert-${css} alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <strong>${msg}</strong>
            </div>
        </c:if>
        <c:if test="${not empty sessionScope.cart.serviceList || not empty sessionScope.cart.productList}">
            <h1>All Items</h1>
            <c:if test="${not emptysessionScope.cart.productList}">
                <table class="table table-striped">
                    <thead> Products
                    <tr>
                        <th>ID</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Order type</th>
                    </tr>
                    </thead>
                    <c:forEach var="item" items="${sessionScope.cart.productList}">
                        <tr>
                            <td>
                                    ${item.id}
                            </td>
                            <td>${item.price}</td>
                            <td>${item.description}</td>
                            <td>${item.orderType}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${not emptysessionScope.cart.serviceList}">
                <table class="table table-striped">
                    <thead> Services
                    <tr>
                        <th>ID</th>
                        <th>Price</th>
                        <th>Description</th>
                    </tr>
                    </thead>
                    <c:forEach var="item" items="${sessionScope.cart.serviceList}">
                        <tr>
                            <td>
                                    ${item.id}
                            </td>
                            <td>${item.price}</td>
                            <td>${item.description}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <h2>Your total is: ${total}$ for ${totalItem} items.</h2>
            <div>
                <spring:url value="/cart/checkout" var="checkoutUrl"/>
                <form action='${checkoutUrl}' method="POST">
                    <fieldset>
                        <legend>Address</legend>
                        <c:if test="${not empty sessionScope.user.address}">
                            <c:set var="count" value="0" scope="page" />
                            <c:forEach var="address" items="${sessionScope.user.address}">
                                <c:set var="count" value="${count + 1}" scope="page"/>
                                <div class="radio">
                                    <c:if test="${ count == 1}">
                                        <label><input type="radio" name="optradio" checked="checked" value="<c:out value="${address.id}"/>">Address #${count}</label>
                                    </c:if>
                                    <c:if test="${ count != 1}">
                                        <label><input type="radio" name="optradio" value="<c:out value="${address.id}"/>">Address #${count}</label>
                                    </c:if>
                                </div>
                                <div class="form-group">
                                    <label for="first-name-input_<c:out value="${address.id}"/>"
                                           class="col-2 col-form-label">First name</label>
                                    <div class="col-10">
                                        <input class="form-control" type="text"
                                               value="<c:out value="${address.firstName}"/>"
                                               id="first-name-input_<c:out value="${address.id}"/>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="last-name-input_<c:out value="${address.id}"/>"
                                           class="col-2 col-form-label">Last name</label>
                                    <div class="col-10">
                                        <input class="form-control" type="text"
                                               value="<c:out value="${address.lastName}"/>"
                                               id="last-name-input_<c:out value="${address.id}"/>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="tel-input_<c:out value="${address.id}"/>" class="col-2 col-form-label">Telephone</label>
                                    <div class="col-10">
                                        <input class="form-control" type="tel"
                                               value="<c:out value="${address.phoneNumber}"/>"
                                               id="tel-input_<c:out value="${address.id}"/>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="street-input_<c:out value="${address.id}"/>"
                                           class="col-2 col-form-label">Street address</label>
                                    <div class="col-10">
                                        <input class="form-control" type="text"
                                               value="<c:out value="${address.streetAddress}"/>"
                                               id="street-input_<c:out value="${address.id}"/>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="city-input_<c:out value="${address.id}"/>" class="col-2 col-form-label">Street
                                        address</label>
                                    <div class="col-10">
                                        <input class="form-control" type="text" value="<c:out value="${address.city}"/>"
                                               id="city-input_<c:out value="${address.id}"/>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="zip-code-input_<c:out value="${address.id}"/>"
                                           class="col-2 col-form-label">Zip code</label>
                                    <div class="col-10">
                                        <input class="form-control" type="number"
                                               value="<c:out value="${address.zipCode}"/>"
                                               id="zip-code-input_<c:out value="${address.id}"/>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="state-input_<c:out value="${address.id}"/>"
                                           class="col-2 col-form-label">State</label>
                                    <div class="col-10">
                                        <input class="form-control" type="text"
                                               value="<c:out value="${address.state}"/>"
                                               id="state-input_<c:out value="${address.id}"/>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="country-input_<c:out value="${address.id}"/>"
                                           class="col-2 col-form-label">Country</label>
                                    <div class="col-10">
                                        <input class="form-control" type="text"
                                               value="<c:out value="${address.country}"/>"
                                               id="country-input_<c:out value="${address.id}"/>">
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                        <div class="radio">
                            <c:if test="${not empty sessionScope.user.address}">
                            <label><input type="radio" name="optradio" value="-1">New address</label>
                        </c:if>
                            <c:if test="${ empty sessionScope.user.address}">
                                <label><input type="radio" name="optradio" checked="checked" value="-1">New address</label>
                            </c:if>
                        </div>
                        <div class="form-group">
                            <label for="first-name-input" class="col-2 col-form-label">First name</label>
                            <div class="col-10">
                                <input class="form-control" type="text"
                                       value="<c:out value="${address.firstName}"/>"
                                       id="first-name-input">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="last-name-input" class="col-2 col-form-label">Last name</label>
                            <div class="col-10">
                                <input class="form-control" type="text"
                                       value="<c:out value="${address.lastName}"/>"
                                       id="last-name-input">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="tel-input" class="col-2 col-form-label">Telephone</label>
                            <div class="col-10">
                                <input class="form-control" type="tel"
                                       value="<c:out value="${address.phoneNumber}"/>"
                                       id="tel-input">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="street-input"
                                   class="col-2 col-form-label">Street address</label>
                            <div class="col-10">
                                <input class="form-control" type="text"
                                       value="<c:out value="${address.streetAddress}"/>"
                                       id="street-input">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="city-input" class="col-2 col-form-label">Street
                                address</label>
                            <div class="col-10">
                                <input class="form-control" type="text" value="<c:out value="${address.city}"/>"
                                       id="city-input">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="zip-code-input"
                                   class="col-2 col-form-label">Zip code</label>
                            <div class="col-10">
                                <input class="form-control" type="number"
                                       value="<c:out value="${address.zipCode}"/>"
                                       id="zip-code-input">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="state-input"
                                   class="col-2 col-form-label">State</label>
                            <div class="col-10">
                                <input class="form-control" type="text"
                                       value="<c:out value="${address.state}"/>"
                                       id="state-input">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="country-input"
                                   class="col-2 col-form-label">Country</label>
                            <div class="col-10">
                                <input class="form-control" type="text"
                                       value="<c:out value="${address.country}"/>"
                                       id="country-input">
                            </div>
                        </div>
                    </fieldset>
                    <fieldset>
                        <legend>Payment</legend>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="card-holder-name">Name on Card</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="card-holder-name" id="card-holder-name"
                                       placeholder="Card Holder's Name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="card-number">Card Number</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="card-number" id="card-number"
                                       placeholder="Debit/Credit Card Number">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="expiry-month">Expiration Date</label>
                            <div class="col-sm-9">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <select class="form-control col-sm-2" name="expiry-month" id="expiry-month">
                                            <option>Month</option>
                                            <option value="01">Jan (01)</option>
                                            <option value="02">Feb (02)</option>
                                            <option value="03">Mar (03)</option>
                                            <option value="04">Apr (04)</option>
                                            <option value="05">May (05)</option>
                                            <option value="06">June (06)</option>
                                            <option value="07">July (07)</option>
                                            <option value="08">Aug (08)</option>
                                            <option value="09">Sep (09)</option>
                                            <option value="10">Oct (10)</option>
                                            <option value="11">Nov (11)</option>
                                            <option value="12">Dec (12)</option>
                                        </select>
                                    </div>
                                    <div class="col-xs-3">
                                        <select class="form-control" name="expiry-year">
                                            <option value="17">2017</option>
                                            <option value="18">2018</option>
                                            <option value="19">2019</option>
                                            <option value="20">2020</option>
                                            <option value="21">2021</option>
                                            <option value="22">2022</option>
                                            <option value="23">2023</option>
                                            <option value="24">2024</option>
                                            <option value="25">2025</option>
                                            <option value="26">2026</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="cvv">Card CVV</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" name="cvv" id="cvv" placeholder="Security Code">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                            </div>
                        </div>
                    </fieldset>
                    <button type="submit" class="btn btn-success">Pay Now</button>
                </form>
            </div>
        </c:if>
        <c:if test="${!(not empty sessionScope.cart.serviceList || not empty sessionScope.cart.productList)}">
            <h1>Cart is empty</h1>
        </c:if>
    </div>
</div>
<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>