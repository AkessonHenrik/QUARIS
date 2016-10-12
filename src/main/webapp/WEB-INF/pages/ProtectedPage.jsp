<%@include file="include/head.jsp" %>

<%@include file="include/navbar.jsp" %>

<div class="wrapper">
    <div class="container">
        <h1>Users</h1>

        <div class="content">
            <table id="users-table" class="table table-striped" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th class="username">Name</th>
                </tr>
                </thead>
            </table>

            <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}">Go home</a>
        </div>
    </div>
</div>


<script src="//code.jquery.com/jquery-1.12.3.js"></script>
<script src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.js"></script>
<script src="//cdn.datatables.net/1.10.12/js/dataTables.bootstrap4.min.js"></script>

<script>
    jQuery('#users-table').DataTable({
        serverSide: true,
        columns: [
            { "data": "username" },
        ],
        ajax: {
            url: "${pageContext.request.contextPath}/api/users",
            dataSrc: ""
        }
    })
</script>

<%@include file="include/footer.jsp" %>