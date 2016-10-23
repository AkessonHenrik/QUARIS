<%@ include file="../include/jsp-config.jsp" %>

<t:layout-main>
    <jsp:attribute name="head">
        <link rel="stylesheet" href="//cdn.datatables.net/1.10.12/css/dataTables.bootstrap4.min.css">
    </jsp:attribute>

    <jsp:attribute name="scripts">
        <script src="//code.jquery.com/jquery-1.12.3.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.js"></script>
        <script src="//cdn.datatables.net/1.10.12/js/dataTables.bootstrap4.min.js"></script>

        <script>
            $(document).ready(function() {
                var usersTable = jQuery('#users-table').DataTable({
                    columns: [
                        { data: 'username' },
                        { data: 'email' },
                    ],
                    ajax: {
                        url: '${pageContext.request.contextPath}/api/users',
                        dataSrc: ''
                    }
                })

                // Create a new user (ajax)
                $(".create-new-user").on("click", function () {
                    var user = {
                        username: $("[name=username]").val(),
                        email: $("[name=email]").val(),
                        password: $("[name=password]").val()
                    }

                    $.post("${pageContext.request.contextPath}/auth/register", user)
                            .done(function () {
                                usersTable.ajax.reload();
                            })
                })
            })
        </script>
    </jsp:attribute>

    <jsp:body>
        <%@include file="../include/navbar.jsp" %>

        <div class="wrapper">
            <div class="container">
                <h1>Users</h1>

                <div class="content">
                    <div class="clearfix mb-1">
                        <button type="button" class="btn btn-primary float-xs-right" data-toggle="modal" data-target="#new-user-modal">
                            Create a new user
                        </button>
                    </div>
                    <table id="users-table" class="table table-striped">
                        <thead>
                            <tr>
                                <th class="username">Username</th>
                                <th class="email">Email</th>
                            </tr>
                        </thead>
                    </table>

                    <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}">Go home</a>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="new-user-modal" tabindex="-1" role="dialog" aria-labelledby="new-user-modal-label" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title" id="new-user-modal-label">Create a new user</h4>
                    </div>
                    <div class="modal-body">

                        <form class="form-signin" method="post">
                            <label for="inputUsername">Username</label>
                            <input name="username" id="inputUsername" class="form-control" placeholder="Username" required autofocus>

                            <label for="inputEmail">Email</label>
                            <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email" required>

                            <label for="inputPassword">Password</label>
                            <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
                        </form>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary create-new-user" data-dismiss="modal">Create</button>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout-main>