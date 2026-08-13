//
//  LoginBottomSheetViewModel.swift
//  02 - Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 16/06/25.
//

import Foundation
import FirebaseAuth

class LoginViewModel {
    var onLoginSucess: ((String) -> Void)?
    var onLoginError: ((String) -> Void)?
    
    func doAuthentication(username: String, password: String) {
        Auth.auth().signIn(withEmail: username, password: password) { [weak self] (authResult: AuthDataResult?, error: Error?) in
            if let error = error {
                print("Auth error: \(error.localizedDescription)")
                self?.onLoginError?("Erro ao autenticar, verifique as credenciais digitadas.")
                
            } else {
                self?.onLoginSucess?(username)
            }
        }
    }
}
