const url = 'http://localhost:8080/rest/';

const app = angular.module('myApp', [])

app.controller('ctrl', function ($scope, $http) {
        $scope.form = {};
        $scope.students = [];

        $scope.reset = function () {
            $scope.form = {gender: true, country: 'VN', email: null};
        }

        $scope.loadAll = function () {
            $http.get(url + 'students').then(function (response) {
                $scope.students = response.data
            })
        }

        $scope.add = function () {
            $http.post(url + 'students', angular.copy($scope.form)).then(function (response) {
                $scope.loadAll();
                $scope.reset();
            })
        }

        $scope.delete = function (email) {
            $http.delete(url + 'students/' + email).then(function (response) {
                $scope.loadAll();
                $scope.reset();
            })
        }

        $scope.edit = function (email) {
           $http.get(url + 'students/' + email).then(function (response) {
               $scope.form = response.data
           })
        }

        $scope.update = function () {
            $http.put(url + 'students/' + $scope.form.email, angular.copy($scope.form)).then(function (response) {
                $scope.loadAll();
                $scope.reset();
            })
        }

        $scope.loadAll();
    }
)