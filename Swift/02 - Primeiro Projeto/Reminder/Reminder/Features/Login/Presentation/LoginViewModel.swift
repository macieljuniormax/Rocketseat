//
//  LoginBottomSheetViewModel.swift
//  02 - Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 16/06/25.
//

import Foundation
import Firebase

class LoginViewModel {
    var onLoginSucess: ((String) -> Void)?
    var onLoginError: ((String) -> Void)?
    
    func doAuthentication(username: String, password: String) {
        Firebase.Auth.auth().signIn(withEmail: username, password: password) { [weak self] authDataResult, error in
            if let error = error {
                self?.onLoginError?("Erro ao autenticar, verifique as credenciais digitadas.")
                
            } else {
                self?.onLoginSucess?(username)
            }
        }
    }
}
