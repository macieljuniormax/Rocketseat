//
//  LoginBottomSheetViewModel.swift
//  02 - Reminder
//
//  Created by Maciel Ferreira Custódio Júnior on 16/06/25.
//

import Foundation
import Firebase

class LoginBottomSheetViewModel {
    var succesResult:  (() -> Void)?
    
    func doAuthentication(username: String, password: String) {
        print(username)
        Firebase.Auth.auth().signIn(withEmail: username, password: password) { [weak self] authDataResult, error in
            if let error = error {
                print("Autenticação não foi realizada com sucesso \(error)")
                
            } else {
                self?.succesResult?()
            }
        }
    }
}
