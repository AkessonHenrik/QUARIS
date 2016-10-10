<%@include file="include/head.jsp" %>

<%@include file="include/navbar.jsp" %>

<div class="coming-soon">
    <div class="container">
        <h2 class="title">If you see this it's because you're logged in!</h2>

        <table id="users-table" class="table table-striped" width="100%" cellspacing="0">
            <thead>
            <tr>
                <th class="username">Name</th>
            </tr>
            </thead>
        </table>

        <a class="btn btn-lg btn-outline-secondary" href="${pageContext.request.contextPath}">Go home</a>
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