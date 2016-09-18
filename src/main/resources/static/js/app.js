angular.module('passgen',[])

.controller('passgenController', function($scope,$http){
	
	$scope.password="";
	$scope.selectedOption="Without special character";
	$scope.options = ["Without special character", "With special character"];
	$scope.withSc = "";
	
	$scope.generatePassword = function(){
		
		 
		 
		 if($scope.selectedOption==="With special character"){
			 $scope.withSc=true;
			 $scope.specialChar;
		 }else{
			 $scope.withSc=false;
		 }
		
		 var request = {withSC:$scope.withSc,
				 			specialCharacter:$scope.specialChar}
		 
		 console.log(request);
		 
		$http.post("/password",request).success(function(data){
			$scope.password=data.password;
		});
	}
	
//	$scope.generatePassword();
	
});