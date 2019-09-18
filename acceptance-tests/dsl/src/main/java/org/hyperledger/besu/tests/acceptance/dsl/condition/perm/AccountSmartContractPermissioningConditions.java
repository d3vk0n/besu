/*
 * Copyright 2019 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.hyperledger.besu.tests.acceptance.dsl.condition.perm;

import org.hyperledger.besu.tests.acceptance.dsl.account.Account;
import org.hyperledger.besu.tests.acceptance.dsl.condition.Condition;
import org.hyperledger.besu.tests.acceptance.dsl.transaction.perm.AccountSmartContractPermissioningTransactions;

public class AccountSmartContractPermissioningConditions {

  private final AccountSmartContractPermissioningTransactions transactions;

  public AccountSmartContractPermissioningConditions(
      final AccountSmartContractPermissioningTransactions transactions) {
    this.transactions = transactions;
  }

  public Condition accountIsAllowed(final String address, final Account account) {
    return new WaitForTrueResponse(transactions.isAccountAllowed(address, account));
  }

  public Condition accountIsForbidden(final String address, final Account account) {
    return new WaitForFalseResponse(transactions.isAccountAllowed(address, account));
  }
}