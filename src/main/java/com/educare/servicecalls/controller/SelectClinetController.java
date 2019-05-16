package com.educare.servicecalls.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educare.servicecalls.model.ClientListModel;
import com.educare.servicecalls.model.ClientModel;
import com.educare.servicecalls.model.StatusModel;

@RestController
public class SelectClinetController {

	@RequestMapping(value = "/getallclinets", method = RequestMethod.GET, produces = "application/json")
	private ClientListModel getallclinets(HttpServletRequest request) {
		ClientListModel cl = new ClientListModel();
		List<ClientModel> lst = new ArrayList<>();
		ClientModel cm = new ClientModel();
		ClientModel cm1 = new ClientModel();
		ClientModel cm2 = new ClientModel();
		cm.setClientid(1);
		cm.setClientname("Electus 1");
		cm1.setClientid(2);
		cm1.setClientname("Electus 2");
		cm2.setClientid(3);
		cm2.setClientname("Electus 3");
		lst.add(cm);
		lst.add(cm1);
		lst.add(cm2);
		cl.setData(lst);

		return cl;
	}

	@RequestMapping(value = "/processClient", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<StatusModel> processClient(HttpServletRequest request, HttpServletResponse response) {
		StatusModel sdm = new StatusModel();
		String id = request.getParameter("clientid");
		String response1 = "";
		HttpSession session = request.getSession();

		try {

			String one = id;
			/** database selection**/
			session.setAttribute("keyDS", one);
			if (one.equals("1")) {
				response1 = "accepted";
				sdm.setData(response1);
			}
			return new ResponseEntity<>(sdm, HttpStatus.OK);
		} catch (Exception ex) {
			String errorMessage;
			errorMessage = ex + " <== error";
			sdm.setData("errorfffffffff" + errorMessage);

			return new ResponseEntity<>(sdm, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
