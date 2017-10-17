
var todo = angular.module('todo',["ngRoute"]);
todo.config([ '$routeProvider',
    function($routeProvider) {
        $routeProvider.when('/', {
            templateUrl : 'templates/home.html',
            controller : 'appController'
        })
        .when("/todo", {
            templateUrl : "templates/todo.html",
            controller : 'serviceController'
        });
    }
]);

todo.controller('appController',function($scope, appService, shareTodoData){

    $scope.showAddTodoDialog = true;

   appService.getTodoData().then(function (response) {
        $scope.todoData = response.data;
    });

   $scope.setTodoData = function(service){
        shareTodoData.setTodoData(service);
    };

   $scope.showAddTodo = function(){
        $scope.showAddTodoDialog = !$scope.showAddTodoDialog;
    };

    $scope.addTodo = function(){
       

    };
});

//Controller for handling each RESTService
todo.controller('serviceController',function($scope, shareTodoData){
    //$scope.service = shareTodoData.getTodoData();
  

    
});

//This service is ajax request to get todo data
todo.service('appService',function ($http) {
    this.getTodoData = function(){
         return $http.get("/api/todos/all");
    };

   /* this.addNewTodo = function(todoName, description,serviceBody){
        //User the parameter passed to pass to post request

        var data = {
            name: todoName,
            context: description
        };
        var myobj1 = eval(serviceBody);
        return $http.post("/api/todos", data);
    }*/
});

todo.service('shareTodoData',function ($http) {
    var todoData;

    this.getTodoData = function(){
        return todoData;
    };

    this.setTodoData = function(data){
    	todoData = data;
    };

});