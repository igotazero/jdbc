function labelsVisible(checkbox) {
    if (checkbox != null){
    	if (checkbox.checked){
    		$("input[name='gap']").attr('disabled', true);
    		$("input[name='time_left']").attr('disabled', true);
    	}else{
    		$("input[name='gap']").attr('disabled', false);
    		$("input[name='time_left']").attr('disabled', false);
    	}
    }
}